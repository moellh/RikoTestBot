package de.riko.discord.rikoTestBot.commands;

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
	public abstract void doAction(final MessageReceivedEvent event);
	
}
