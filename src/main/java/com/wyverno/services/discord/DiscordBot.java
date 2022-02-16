package com.wyverno.services.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class DiscordBot {
    private static JDA JDA = null;
    public static final Logger logger = LoggerFactory.getLogger(DiscordBot.class);

    public static JDA getBot() { // Pattern Singleton
        if (JDA == null) {
            try {
                logger.trace("Loading config.properties");
                String fileConfig = DiscordBot.class.getClassLoader().getResource("config.properties").getFile();
                Properties properties = new Properties();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileConfig)))) {
                    properties.load(reader);
                    logger.trace("Loaded config.properties");
                }
                logger.trace("Reading token from config");
                JDABuilder builder = JDABuilder.createDefault(properties.getProperty("DISCORD_API_TOKEN"));
                logger.trace("Read token from config");

                logger.info("Starting bot");
                JDA = settingJDA(builder).build();
                logger.info("Started bot");
            } catch (Throwable throwable) {
                logger.error("FATAL ERROR STACKTRACE:", throwable);
            }
        }
        return JDA;
    }

    private static JDABuilder settingJDA(JDABuilder builder) {
        logger.info("Setting up the Builder bot");

        builder.setActivity(Activity.streaming("Java streaming...","https://www.twitch.tv/fomka_wyverno"));
        builder.addEventListeners(new MessageListener());

        logger.info("Complected settings for Builder bot");
        return builder;
    }

    public static void stopBot() {
        logger.info("Stopping bot...");
        getBot().shutdown();
        logger.info("Stopped bot");
    }
}
