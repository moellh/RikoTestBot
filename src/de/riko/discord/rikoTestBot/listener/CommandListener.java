package de.riko.discord.rikoTestBot.listener;

import java.util.Arrays;
import java.util.List;

import de.riko.discord.rikoTestBot.commands.CommandManager;
import de.riko.discord.rikoTestBot.dedicatedManagers.ChannelManager;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter{
	
	private final CommandManager commandManager;
	
	public static final String defaultPrefix = "!";
	
	public CommandListener(final CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
	@Override
	public void onMessageReceived(final MessageReceivedEvent event) {
		final String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			final String prefix = ChannelManager.getChannelPrefix(event.getChannel(), defaultPrefix);
			if(message.startsWith(prefix)) {
				commandManager.checkAndRunCommand(event, getArguments(message.substring(prefix.length())));
			}
		}
	}
	
	private List<String> getArguments(final String rawMessage){
		final String[] argumentArray = rawMessage.split(" ");
		final List<String> arguments = Arrays.asList(argumentArray);
		return arguments.stream().filter(argument -> !(argument.equals(" ") || argument.equals(""))).toList();
	}
	
}
