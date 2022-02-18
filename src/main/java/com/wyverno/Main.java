package com.wyverno;

import com.wyverno.controller.controllerDiscord.ControllerDiscord;
import com.wyverno.model.Model;
import com.wyverno.view.View;
import com.wyverno.view.viewDiscordBot.ViewDiscordBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            View view = new ViewDiscordBot();
            logger.info("Created view.");
            Model model = new Model(view);
            logger.info("Created model.");
            ControllerDiscord controller = new ControllerDiscord(model);
            controller.setListenerTextChats(); // Активируем прослушку чатов
            logger.info("Created controller.");

        } catch (Throwable e) {
            logger.error("Fatal ERROR:",e);
        }
    }
}
