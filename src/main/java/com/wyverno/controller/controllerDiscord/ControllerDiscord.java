package com.wyverno.controller.controllerDiscord;

import com.wyverno.controller.Controller;
import com.wyverno.model.Model;
import com.wyverno.services.discord.DiscordBot;
import com.wyverno.services.discord.listeners.MessageListener;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerDiscord extends Controller { // Pattern Observer

    private final static Logger logger = LoggerFactory.getLogger(ControllerDiscord.class);

    public ControllerDiscord(@NotNull Model model) {
        super(model);
        DiscordBot.initDiscordBot(); // Для работы Discord Controller нужно иницилицировать в любом случае DiscordBot
    }

    @Override
    public void update(Object observable, Object arg) { // Принимаем обновление наблюдаемых обьектов
        logger.debug("Controller run method update()");
        logger.trace("Observable = " + observable.getClass().getName());
        if (observable instanceof MessageListener) {
            logger.trace("Observable is MessageListener.");
            MessageReceivedEvent event = (MessageReceivedEvent) arg;
            MODEL.acceptMessageEvent(event);
        }
    }

    public void setListenerTextChats() { // Подписываем контроллер на прослушку чатов
        MessageListener messageListener = new MessageListener(); // Создаем прослушку для чатов
        messageListener.addObserver(this); // Добавляем для прослушки наблюдатель (Контроллер) который отсылает наблюдателю когда что то пришло
        DiscordBot.getBot().addEventListener(messageListener); // Добавляем прослушку для бота что бы он закидывал ивенты в MessageListener
    }
}
