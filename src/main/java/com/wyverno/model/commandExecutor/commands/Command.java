package com.wyverno.model.commandExecutor.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    ResultTaskCommand executeCommand(MessageReceivedEvent message);
}
