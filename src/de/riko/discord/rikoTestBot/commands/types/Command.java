package de.riko.discord.rikoTestBot.commands.types;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
@FunctionalInterface
public interface Command {
	
	/**
	 * An implemented action is invoked. 
	 * 
	 * @param event for various Disord-related functionalities
	 */
	public void performAction(final MessageReceivedEvent event);
	
	public static void sendMessage(final MessageReceivedEvent event, final String message) {
		event.getChannel().sendMessage(message).queue();
	}
	
}
