package de.riko.discord.rikoTestBot.commands;

import java.util.List;
import java.util.Optional;

import de.riko.discord.rikoTestBot.commands.rikoTestBotCommands.AddPrefixForChannelCommand;
import de.riko.discord.rikoTestBot.commands.rikoTestBotCommands.RemovePrefixForChannelCommand;
import de.riko.discord.rikoTestBot.commands.rikoTestBotCommands.RikoTestBotCommandHelpCommand;
import de.riko.discord.rikoTestBot.commands.rikoTestBotCommands.SayHiCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Implementation of CommandManager for RikoTestBot.
 * Includes commands such as 'hi' or 'help'.
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class RikoTestBotCommandManager extends CommandManager {

	/**
	 * Matches Command arguments with RikoTestBot-Commands.
	 */
	@Override
	public Optional<Command> searchCommand(final MessageReceivedEvent event, final List<String> arguments) {
		switch(arguments.get(0).toLowerCase()) {
		case "hi": return Optional.of(new SayHiCommand(event.getAuthor()));
		case "help": return Optional.of(new RikoTestBotCommandHelpCommand());
		case "removeprefix": return Optional.of(new RemovePrefixForChannelCommand());
		case "addprefix": return Optional.of(new AddPrefixForChannelCommand());
		default: return Optional.empty();
		}
	}
}
