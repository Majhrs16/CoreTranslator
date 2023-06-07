# CoreTranslator

## ¿Qué es CoreTranslator?

CoreTranslator (CoT) es una expansión de ChatTranslator que permite un control total de la API de ChatTranslator y la traducción de cualquier texto en el servidor de Minecraft de forma fraccionada. CoT te permite ahorrar tiempo y mejorar la eficacia de tu servidor de Minecraft.

## Características

- Total control de la API de [ChatTranslator](https://www.spigotmc.org/resources/chattranslator.106604/) (ChT).
- Capacidad de traducir cualquier texto en el servidor de forma fraccionada.
- Soporte para [HolographicsDisplays](https://dev.bukkit.org/projects/holographic-displays) y [ConditionalEvents](https://www.spigotmc.org/resources/conditionalevents-custom-actions-for-certain-events-1-8-1-19-4.82271/).
- Dependencias: [ChatTranslator](https://www.spigotmc.org/resources/chattranslator.106604/), [PlaceHolderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/), y [ConditionalEvents](https://www.spigotmc.org/resources/conditionalevents-custom-actions-for-certain-events-1-8-1-19-4.82271/) (opcional).

## Instalación

1. Descarga la última versión de CoreTranslator desde la página de [SpigotMC](no disponible) o desde el [GitHub](https://github.com/Majhrs16/CoreTranslator/releases).
2. Coloca el archivo jar en la carpeta /expansions de [PlaceHolderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/), no en la carpeta de plugins.
3. No es necesario reiniciar el servidor, simplemente ejecuta el comando /papi reload.
4. ¡Listo para usar!

## Configuración

Después de instalar CoreTranslator, puedes ajustar la configuración en el archivo config.yml dentro de la carpeta /plugins/ChatTranslator. En el archivo de configuración, encontrarás opciones para ajustar el idioma predeterminado, el formato de salida y otras configuraciones relacionadas con el comportamiento del plugin.

Si utilizas [ConditionalEvents](https://www.spigotmc.org/resources/conditionalevents-custom-actions-for-certain-events-1-8-1-19-4.82271/), puedes personalizar aún más el chat cancelando el evento majhrs16.ct.events.custom.Message, y utilizando la variable %ct_sendMessage...% en su lugar. Además, puedes abreviar los formatos utilizando el nombre del grupo de formato almacenado en la config del ChT.

## Uso

Para utilizar CoreTranslator, necesitas tener instalados [ChatTranslator](https://www.spigotmc.org/resources/chattranslator.106604/) y [PlaceHolderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/), como requisitos previos. Una vez que tengas estos plugins instalados, puedes utilizar los siguientes métodos para traducir cualquier texto en el servidor de forma fraccionada:
    La sintaxis completa de la variable de sendMessage es:
    
    `%ct_sendMessage_['{from_name}', '{formato_del_mensaje}', '{messages}', '{tool_tips}', '{sonidos}', Boolean show, '{from_lang}', Boolean color, Boolean PAPI]: ['{to_name}', '{configuación_guardada_en_ChT}', '{messages}', '{configuacion_guardada_en_ChT}', '{configuacion_guardada_en_ChT}', Boolean show, '{to_lang}', Boolean color, Boolean PAPI]%`
        (Todo lo que está encerrado en {} son variables externas)
    
    También puedes utilizar la variable `%ct_translate_<sourceLang>_<targetLang>_<mensaje>%`, para extraer el source/target Lang se puede utilizar `%ct_getLang_<player_name>%`.

La documentación completa de los comandos y eventos se puede encontrar en la página de SpigotMC de ChatTranslator.

## Soporte y Contribuciones

Si necesitas ayuda o tienes alguna pregunta sobre CoreTranslator, puedes unirte a nuestro servidor de [Discord](https://discord.gg/kZxHnSVPTg). ¡Estaremos encantados de ayudarte a sacar el máximo provecho del plugin! Si tienes interés en contribuir al desarrollo de CoreTranslator, puedes encontrar el código fuente en nuestro repositorio de GitHub.

## Licencia

CoreTranslator se distribuye bajo la licencia GPL v3.0. Puedes encontrar una copia de la licencia visitando la página oficial de la Free Software Foundation.