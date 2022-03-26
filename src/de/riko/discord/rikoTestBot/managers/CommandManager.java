package de.riko.discord.rikoTestBot.managers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.riko.discord.rikoTestBot.commands.AddPrefixToChannel;
import de.riko.discord.rikoTestBot.commands.HelpMessage;
import de.riko.discord.rikoTestBot.commands.RemovePrefixFromChannel;
import de.riko.discord.rikoTestBot.commands.SayHi;
import de.riko.discord.rikoTestBot.commands.types.Command;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Manages incoming arguments and matches it with commands of subclass-implementations.
 * Runs command-action and debugs basic command-search results.
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class CommandManager extends ListenerAdapter {
	
	public final static String DEFAULTPREFIX = "!";
	
	private final BotManager botManager;
	private final Map<String, Command> activeCommands;
	
	public CommandManager(final BotManager botManager) {
		this.botManager = botManager;
		activeCommands = getCommandMap();
	}
	
	public Map<String, Command> getCommandMap() {
		final Map<String, Command> commands = new HashMap<>();
		
		commands.put("help", new HelpMessage());
		commands.put("hi", new SayHi());
		commands.put("removeprefix", new RemovePrefixFromChannel(botManager.getChannelManager()));
		commands.put("addprefix", new AddPrefixToChannel(botManager.getChannelManager()));
		
		return commands;
	}
	
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
		final Command command = activeCommands.get(arguments.get(0).toLowerCase());
		if(command != null){
			command.performAction(event);
		}
		printSearchCommandResultsBy(command != null);
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
	
	@Override
	public void onMessageReceived(final MessageReceivedEvent event) {
		final String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			final ChannelManager channelManager = botManager.getChannelManager();
			final String prefix = channelManager.getChannelPrefix(event.getChannel(), DEFAULTPREFIX);
			if(message.startsWith(prefix)) {
				checkAndRunCommand(event, getArguments(message.substring(prefix.length())));
			}
		}
	}
	
	private List<String> getArguments(final String rawMessage){
		final String[] argumentArray = rawMessage.split(" ");
		final List<String> arguments = Arrays.asList(argumentArray);
		return arguments.stream().filter(argument -> !(argument.equals(" ") || argument.equals(""))).toList();
	}
	
}
