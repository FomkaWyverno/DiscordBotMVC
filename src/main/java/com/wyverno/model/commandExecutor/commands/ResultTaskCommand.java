package com.wyverno.model.commandExecutor.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ResultTaskCommand {

    private MessageReceivedEvent event;
    private String result;

    public ResultTaskCommand(MessageReceivedEvent event, String result) {
        this.event = event;
        this.result = result;
    }
}
