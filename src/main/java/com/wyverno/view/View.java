package com.wyverno.view;

import net.dv8tion.jda.api.entities.MessageChannel;

public interface View {
    void sendMessageToTextChannel(MessageChannel channel, String message);

}
