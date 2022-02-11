package com.wyverno.view;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class View {

    public static final JDA JDA;
    public static final Logger logger = LoggerFactory.getLogger(View.class);

    static {
        JDA = null;
        try {

        } catch (Throwable throwable) {
            logger.error("Error while loading JDA");
        }
    }

    public static void main(String[] args) {
        try {
            Properties config = new Properties();
            logger.trace("Loading config...");
            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(
                                    View.class.getClassLoader().
                                            getResource("config.properties").getFile()
                            )))) {
                logger.trace("Reading config");
                config.load(reader);
            }
            logger.trace("Reading token for JDA from config");
            JDABuilder JdaBuilder = JDABuilder.createDefault(config.getProperty("DISCORD_API_TOKEN"));
            logger.info("Starting bot");

        } catch (Throwable t) {
            logger.error("FATAL ERROR STACKTRACE:",t);
        }


    }
}
