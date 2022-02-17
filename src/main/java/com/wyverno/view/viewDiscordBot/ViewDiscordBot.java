package com.wyverno.view.viewDiscordBot;

import com.wyverno.services.discord.DiscordBot;
import com.wyverno.view.View;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewDiscordBot implements View {

    public static final Logger logger = LoggerFactory.getLogger(ViewDiscordBot.class);

    private final JDA BOT;

    public ViewDiscordBot() {
        this.BOT = DiscordBot.getBot();
    }

    public JDA getBot() {
        return this.BOT;
    }

    @Override
    public void sendMessage(String message) {

    }
}