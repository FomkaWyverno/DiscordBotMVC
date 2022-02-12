package com.wyverno.model;

import com.wyverno.view.View;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.internal.entities.ActivityImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Model {

    private static JDA JDA = null;
    public static final Logger logger = LoggerFactory.getLogger(Model.class);

    public static JDA getJDA() { // Pattern Singleton
        if (JDA != null) {
            return JDA;
        } else {
            try {
                logger.trace("Loading config.properties");
                String fileConfig = View.class.getClassLoader().getResource("config.properties").getFile();
                Properties properties = new Properties();
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileConfig)))) {
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
                logger.error("FATAL ERROR STACKTRACE:",throwable);
            }
            return JDA;
        }
    }

    public static void stopJDA() {
        logger.info("Stopping bot...");
        getJDA().shutdown();
        logger.info("Stopped bot");
    }

    private static JDABuilder settingJDA(JDABuilder builder) {
        logger.info("Setting up the Builder bot");

        logger.info("Complected settings for Builder bot");
        return builder;
    }
}
