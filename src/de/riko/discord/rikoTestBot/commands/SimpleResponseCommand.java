package de.riko.discord.rikoTestBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * For Commands with a single response message.
 * Message has to be set in subclass.
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public abstract class SimpleResponseCommand implements Command{
	
	protected String message;
	
	/**
	 * Sends a single message to author's channel.
	 * The message-String has to be set previously in subclass.
	 * 
	 * @param event
	 */
	@Override
	public void doAction(final MessageReceivedEvent event) {
		event.getChannel().sendMessage(message).queue();
	}
	
}
