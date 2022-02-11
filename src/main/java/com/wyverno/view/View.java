package com.wyverno.view;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;import java.io.*;
import java.util.Properties;

public class View {

    public static final Logger logger = LoggerFactory.getLogger(View.class);

    private static JDA JDA = null;

    public static void main(String[] args) throws InterruptedException {
        getJDA();
        Thread.sleep(5000);
        stopJDA();
    }

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
                JDA = builder.build();
                logger.info("Started bot");
            } catch (Throwable throwable) {
                logger.error("FATAL ERROR STACKTRACE:",throwable);
            }
            return JDA;
        }
    }

    private static void stopJDA() {
        logger.info("Stopping bot...");
        getJDA().shutdown();
        logger.info("Stopped bot");
    }
}
