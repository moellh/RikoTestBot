package de.riko.discord.rikoTestBot.managers;

import java.util.HashSet;
import java.util.Set;

import net.dv8tion.jda.api.entities.Channel;

/**
 * Enables dedicated functionalities to certain Channels:<p>
 * - dedicated Bot-Channels work without Bot-Prefix
 * 
 * @author Henrik Möllmann
 * @version 1.0
 */
public class ChannelManager {

	private final Set<Channel> prefixlessChannels = new HashSet<>();
	
	/**
	 * Returns a defaulPrefix depending on whether channel uses a prefix.
	 * If channel is a prefixless Channel, an empty String ("") is returned.
	 * Otherwise defaultPrefix.
	 * 
	 * @param channel
	 * @param defaultPrefix
	 * @return empty String or defaultPrefix
	 */
	public String getChannelPrefix(final Channel channel, final String defaultPrefix) {
		if(prefixlessChannels.contains(channel)) {
			return "";
		}
		return defaultPrefix;
	}
	
	/**
	 * @param channel
	 * @return true if channel is a prefixless Channel
	 */
	public boolean isDedicatedBotChannel(final Channel channel) {
		return prefixlessChannels.contains(channel);
	}
	
	/**
	 * Adds a channel to prefixless Channels.
	 * Ensures that getChannelPrefix returns an empty String.
	 * 
	 * @param addedChannel
	 */
	public void removePrefixForChannel(final Channel addedChannel) {
		prefixlessChannels.add(addedChannel);
	}
	
	/**
	 * Removes a channel from prefixless Channels.
	 * Ensures that getChannelPrefix returns defaultPrefix.
	 * 
	 * @param removedChannel
	 */
	public void addPrefixForChannel(final Channel removedChannel) {
		prefixlessChannels.remove(removedChannel);
	}
	
}
