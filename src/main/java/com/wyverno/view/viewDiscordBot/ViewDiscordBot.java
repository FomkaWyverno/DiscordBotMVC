package com.wyverno.view.viewDiscordBot;

import com.wyverno.services.discord.DiscordBot;
import com.wyverno.view.View;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewDiscordBot implements View {

    public static final Logger logger = LoggerFactory.getLogger(ViewDiscordBot.class);

    public ViewDiscordBot() {
        DiscordBot.initDiscordBot(); // Для работы Discord View нужно обезательно иницилизировать Discord Bot
    }

    @Override
    public void sendMessageToTextChannel(MessageChannel channel, String message) { // Отправляем сообщение в чат
        logger.debug("Bot send message: " + message);
        channel.sendMessage(message).queue();
    }
}
