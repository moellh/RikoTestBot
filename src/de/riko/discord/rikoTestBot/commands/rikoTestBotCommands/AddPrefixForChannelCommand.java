package de.riko.discord.rikoTestBot.commands.rikoTestBotCommands;

import de.riko.discord.rikoTestBot.commands.SimpleResponseCommand;
import de.riko.discord.rikoTestBot.dedicatedManagers.ChannelManager;
import de.riko.discord.rikoTestBot.listener.CommandListener;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AddPrefixForChannelCommand extends SimpleResponseCommand{

	public AddPrefixForChannelCommand() {
		message = "Prefix '" + CommandListener.defaultPrefix + "' required from now on (undo with 'removeprefix')";
	}
	
	@Override
	public void doAction(final MessageReceivedEvent event) {
		ChannelManager.addPrefixForChannel(event.getChannel());
		super.doAction(event);
	}
	
}
