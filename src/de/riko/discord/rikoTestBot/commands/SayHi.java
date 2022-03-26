package de.riko.discord.rikoTestBot.commands;

import de.riko.discord.rikoTestBot.commands.types.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Command: Kindly welcomes author of command :)
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class SayHi implements Command{

	@Override
	public void performAction(final MessageReceivedEvent event) {
		Command.sendMessage(event, "Jo, what's poppin' " + event.getAuthor().getAsMention() + "! ^^");
	}
	
}
