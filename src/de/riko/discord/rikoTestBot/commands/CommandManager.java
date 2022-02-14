package de.riko.discord.rikoTestBot.commands;

import java.util.List;
import java.util.Optional;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Manages incoming arguments and matches it with commands of subclass-implementations.
 * Runs command-action and debugs basic command-search results.
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public abstract class CommandManager {

	/**
	 * Returns command matching arguments.
	 * If no such command exists Optional.empty() is returned (Handling wrong user inputs needs to be implemented in subclasses).
	 * 
	 * @param event for further Discord-functionalites
	 * @param arguments for running most specified commands
	 * @return command if existing
	 */
	protected abstract Optional<Command> searchCommand(final MessageReceivedEvent event, final List<String> arguments);
	
	/**
	 * Searches and runs command.
	 * Also prints basic debug-info.
	 * If no command was found based on arguments, nothing happens.
	 * 
	 * @param event
	 * @param arguments
	 */
	public void checkAndRunCommand(final MessageReceivedEvent event, final List<String> arguments) {
		printSearchingCommand(event, arguments);
		final Optional<Command> command = this.searchCommand(event, arguments);
		if(command.isPresent()) {
			command.get().doAction(event);
		}
		printSearchCommandResultsBy(command.isPresent());
	}

	/**
	 * Prints command arguments: 1. main name of command, 2. further arguments
	 * 
	 * @param event
	 * @param arguments
	 */
	private void printSearchingCommand(final MessageReceivedEvent event, final List<String> arguments) {
		System.out.format("Searching Command: [%s]\n", arguments.toString());
	}
	
	/**
	 * Prints whether command was found and ran or not.
	 * 
	 * @param command
	 */
	private void printSearchCommandResultsBy(final boolean commandFound) {
		if(commandFound) {
			System.out.println("Command was found and was ran!");
		}else {
			System.out.println("No Command found!");
		}
	}
	
}
