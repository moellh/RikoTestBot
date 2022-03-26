package de.riko.discord.rikoTestBot.commands;

import de.riko.discord.rikoTestBot.commands.types.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
	 * Command: Prints commands and its explainations for RikoTestBot 
	 * 
	 * @author Henrik Möllmann
	 * @version 1.0
	 */
	public class HelpMessage implements Command{
		
		@Override
		public void performAction(final MessageReceivedEvent event) {
			final String message = "==== [ List of Commands ] ====\n"
				+ "!hi --- greet the Bot :wave:\n"
				+ "!help --- prints all commands and quite possibly further info about this Bot in the future\n"
				+ "!removeprefix --- using bot-commands from now on only works without any prefix in this channel\n"
				+ "!addprefix --- using bot-commands in this channel requires prefix";
			Command.sendMessage(event, message);
		}
		
	}