package de.riko.discord.rikoTestBot.commands;

import de.riko.discord.rikoTestBot.commands.types.Command;
import de.riko.discord.rikoTestBot.managers.ChannelManager;
import de.riko.discord.rikoTestBot.managers.CommandManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AddPrefixToChannel implements Command{
	
final ChannelManager channelManager;
	
	public AddPrefixToChannel(final ChannelManager channelManager) {
		this.channelManager = channelManager;
	}
	
	@Override
	public void performAction(final MessageReceivedEvent event) {
		Command.sendMessage(event, "Prefix '" + CommandManager.DEFAULTPREFIX + "' required from now on (undo with 'removeprefix')");
		channelManager.addPrefixForChannel(event.getChannel());
	}
		
}
