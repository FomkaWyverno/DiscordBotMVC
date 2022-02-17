package com.wyverno.model;

import com.wyverno.view.View;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Model {

    private final View VIEW;

    public Model(View view) {
        this.VIEW = view;
    }

    public void acceptMessageEvent(MessageReceivedEvent event) { // Принимаем и обрабатываем ивент
        String message = event.getMessage().getContentRaw();
        VIEW.sendMessageToTextChannel(event.getChannel(),message); // Отправляем Вюшке сообщении
    }
}
