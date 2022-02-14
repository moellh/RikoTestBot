package de.riko.discord.rikoTestBot.manager;

import javax.security.auth.login.LoginException;

/**
 * Create a Discord-Bot.
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class BotMain {
	
	/**
	 * Creates a Discord-Bot and prints uncaught Exceptions to console.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		try {
			BotManager.createBot(args[0]);
		} catch (LoginException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
}
