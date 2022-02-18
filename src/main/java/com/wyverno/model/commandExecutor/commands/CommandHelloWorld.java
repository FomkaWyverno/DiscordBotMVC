package com.wyverno.model.commandExecutor.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandHelloWorld implements Command {

    @Override
    public ResultTaskCommand executeCommand(MessageReceivedEvent message) {
        return new ResultTaskCommand(message,"result");
    }
}
