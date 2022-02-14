package de.riko.discord.rikoTestBot.commands.rikoTestBotCommands;

import de.riko.discord.rikoTestBot.commands.SimpleResponseCommand;

/**
	 * Command: Prints commands and its explainations for RikoTestBot 
	 * 
	 * @author Henrik Möllmann
	 * @version 1.0
	 */
	public class RikoTestBotCommandHelpCommand extends SimpleResponseCommand{
		
		/**
		 * Implements response-message with a all commands (+ explaination) of RikoTestBot
		 * 
		 * @param author
		 */
		public RikoTestBotCommandHelpCommand() {
			message = "==== [ List of Commands ] ====\n"
					+ "!hi --- greet the Bot :wave:\n"
					+ "!help --- prints all commands and quite possibly further info about this Bot in the future\n"
					+ "!removeprefix --- using bot-commands from now on only works without any prefix in this channel\n"
					+ "!addprefix --- using bot-commands in this channel requires prefix";
		}
		
	}