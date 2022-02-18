package com.wyverno.model;

import com.wyverno.model.commandExecutor.ExecutorCommands;
import com.wyverno.view.View;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Model {

    private static final Logger logger = LoggerFactory.getLogger(Model.class);

    private final View VIEW;

    public Model(View view) {
        this.VIEW = view;
    }



    public void acceptMessageEvent(MessageReceivedEvent event) { // Принимаем и обрабатываем ивент
        if (!event.getAuthor().isBot()) { // Если это бот игнорируем сообщении.
            String message = event.getMessage().getContentRaw();
            if (message.toCharArray()[0] == '!') { // Узнаем что это комманда
                ExecutorCommands.executeCommand(event); // Выполняем команду
            }
        }

    }


    public void stopProgram() {

    }


}
