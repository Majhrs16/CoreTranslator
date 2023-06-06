package majhrs16.ct;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import majhrs16.ct.events.custom.Message;
import majhrs16.ct.translator.API.API;

public class CoreTranslator extends PlaceholderExpansion {
	API API = new API();
	Pattern sourceLangAndMessage = Pattern.compile("translate_(.+)_(.+)_(.+)", Pattern.CASE_INSENSITIVE);

	Pattern chat                 = Pattern.compile(
		"sendMessage_(" + Message._getRegex() + ")?\\:? ?(" + Message._getRegex() + ")",
		Pattern.CASE_INSENSITIVE);

	Pattern lang                 = Pattern.compile("getLang_(.+)", Pattern.CASE_INSENSITIVE);

	Pattern subVar               = Pattern.compile("\\{[A-Za-z0-9_]+\\}");

	public String getAuthor()     { return "Majhrs16"; }
	public String getVersion()    { return "b1.1.0"; }
	public String getIdentifier() { return "ct"; }

	@Override
	public String onPlaceholderRequest(Player to_player, String identifier) {
		String result;
		Player from_player;

		if (!identifier.contains("{") && identifier.contains("}")) // bug fix CE, add innecesary }.
			identifier = identifier.replace("}", "");

		String input = identifier;
			Matcher SubVar = subVar.matcher(input);

			while (SubVar.find()) {
				input = SubVar.replaceFirst(PlaceholderAPI.setPlaceholders(to_player, "%" + SubVar.group().substring(1, SubVar.group().length() - 1) + "%"));
				SubVar = subVar.matcher(input);
			}
		identifier = PlaceholderAPI.setPlaceholders(to_player, input);

		Matcher SourceLangAndMessage = sourceLangAndMessage.matcher(identifier);
		Matcher Chat                 = chat.matcher(identifier);
		Matcher Lang                 = lang.matcher(identifier);

		if (Chat.find()) {
			Message msg = new Message().valueOf(Chat.group(11));

			if (msg != null) {
				if (Chat.group(1) != null)
					msg.setFather(new Message().valueOf(Chat.group(1)));

				API.sendMessage(msg);

				result = "ok";

			} else {
				result = "null msg";
			}

		} else if (Lang.find()) {
			try {
				from_player = Bukkit.getServer().getPlayer(Lang.group(1));

			} catch (NullPointerException e) {
				from_player = null;
			}

			result = API.getLang(from_player);

		} else if (SourceLangAndMessage.find()) {
			result = API.formatMsg(
				null,
				to_player,
				"$ct_messages$",
				SourceLangAndMessage.group(3), // messages
				SourceLangAndMessage.group(1), // lang_source
				SourceLangAndMessage.group(2), // lang_target
				true,
				false
			);
//			papi parse --null %ct_translate_#ct_getLang_!ct_chat_sender!#_#ct_getLang_!ct_chat_receiver!#_Hola%
//			papi parse --null %ct_translate_en_This server is a multi_language%

		} else if (identifier.equals("test")) {
			result = "Debug, to_player = " + to_player.getName();

		} else {
			result = "%" + getIdentifier() + "_" + identifier + "%";
		}

		return result;
	}
}
