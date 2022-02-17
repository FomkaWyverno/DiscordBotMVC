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
            initDiscordBot();
        }
        return JDA;
    }

    public static void initDiscordBot() { // Включаем бота
        if (JDA == null) {
            logger.info("Start Initialization Discord Bot");
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
                JDA = setStatus(builder).build();
                logger.info("Started bot");
            } catch (Throwable throwable) {
                logger.error("FATAL ERROR STACKTRACE:", throwable);
            }
        }
    }

    private static JDABuilder setStatus(JDABuilder builder) {
        logger.trace("Start setting the status");

        builder.setActivity(Activity.streaming("Java streaming...","https://www.twitch.tv/fomka_wyverno"));

        logger.trace("Set status");
        return builder;
    }

    public static void stopBot() {
        logger.info("Stopping bot...");
        getBot().shutdown();
        logger.info("Stopped bot");
    }
}
