package de.riko.discord.rikoTestBot.commands.rikoTestBotCommands;

import de.riko.discord.rikoTestBot.commands.SimpleResponseCommand;
import de.riko.discord.rikoTestBot.dedicatedManagers.ChannelManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RemovePrefixForChannelCommand extends SimpleResponseCommand{

	public RemovePrefixForChannelCommand() {
		message = "No Prefix required from now on (undo with 'addprefix')";
	}
	
	@Override
	public void doAction(final MessageReceivedEvent event) {
		ChannelManager.removePrefixForChannel(event.getChannel());
		super.doAction(event);
	}

}
