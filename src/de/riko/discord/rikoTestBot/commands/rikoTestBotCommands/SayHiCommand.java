package de.riko.discord.rikoTestBot.commands.rikoTestBotCommands;

import de.riko.discord.rikoTestBot.commands.SimpleResponseCommand;
import net.dv8tion.jda.api.entities.User;

/**
 * Command: Kindly welcomes author of command :)
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class SayHiCommand extends SimpleResponseCommand{

	/**
	 * Implements response-message to author with:
	 * "Jo, what's poppin' @author! ^^"
	 * 
	 * @param author
	 */
	public SayHiCommand(final User author) {
		message = "Jo, what's poppin' " + author.getAsMention() + "! ^^";
	}
	
}
