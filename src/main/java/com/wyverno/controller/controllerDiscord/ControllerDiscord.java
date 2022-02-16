package com.wyverno.controller.controllerDiscord;

import com.wyverno.controller.Controller;
import com.wyverno.model.Model;
import com.wyverno.services.discord.DiscordBot;
import net.dv8tion.jda.api.JDA;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerDiscord extends Controller {

    private final JDA BOT = DiscordBot.getBot();
    private final static Logger logger = LoggerFactory.getLogger(ControllerDiscord.class);

    public ControllerDiscord(@NotNull Model model) {
        super(model);
    }

    @Override
    public void stopProgram() {
        logger.info("Stop the program");
        this.BOT.shutdown();
        logger.info("Stop success");
    }
}
