package de.riko.discord.rikoTestBot.commands;

import de.riko.discord.rikoTestBot.commands.types.Command;
import de.riko.discord.rikoTestBot.managers.ChannelManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RemovePrefixFromChannel implements Command{

	final ChannelManager channelManager;
	
	public RemovePrefixFromChannel(final ChannelManager channelManager) {
		this.channelManager = channelManager;
	}
	
	@Override
	public void performAction(final MessageReceivedEvent event) {
		Command.sendMessage(event, "No Prefix required from now on (undo with 'addprefix')");
		channelManager.removePrefixForChannel(event.getChannel());
	}

}
