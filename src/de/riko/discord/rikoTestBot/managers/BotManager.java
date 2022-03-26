package de.riko.discord.rikoTestBot.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class BotManager {
	
	private final ShardManager shardManager;
	private final ChannelManager channelManager;
	
	/**
	 * Starts a new Discord-Bot using Token and turns it online.
	 * The Bot uses a set CommandManager and Status.
	 * 
	 * @param botName
	 * @throws LoginException
	 * @throws IllegalArgumentException
	 */
	public BotManager(final String token) throws LoginException, IllegalArgumentException {
		final DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
		shardManager = builder.build();
		shardManager.addEventListener(new CommandManager(this));
		Runtime.getRuntime().addShutdownHook(new Thread(() -> this.shutdown()));
		
		channelManager = new ChannelManager();
		
		shardManager.setActivity(Activity.playing("CS:GO MM Silver 1"));
		shardManager.setStatus(OnlineStatus.ONLINE);
		System.out.println("Bot is Online!");
		
		runUntilExit();
	}
	
	/**
	 * Creates and runs a new Bot. There can only be one running Bot.  
	 * 
	 * @param token of Bot-Account
	 * @throws LoginException
	 * @throws IllegalArgumentException
	 */
	public static void createBot(final String token) throws LoginException, IllegalArgumentException {
		new BotManager(token);
	}
	
	
	public void runUntilExit() {
		new Thread(() -> {
			useConsole();
		}).start();
	}

	/**
	 * Uses Console for and runs console-command.
	 * If an input is not a console-command, it will be ignored.
	 */
	private void useConsole() {
		String line = "";
		final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while((line = inputReader.readLine()) != null) {
				if(line.equalsIgnoreCase("exit")) {
					shutdown();
					inputReader.close();
					break;
				}
			}
		}catch(final IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stops Discord-Bot and turn it Offline for quick response inside Discord-Client.
	 */
	public void shutdown() {
		if(shardManager != null) {
			shardManager.setStatus(OnlineStatus.OFFLINE);
			shardManager.shutdown();
			System.out.println("Bot is Offline!");
		}
	}
	
	public ChannelManager getChannelManager() {
		return this.channelManager;
	}
	
}
