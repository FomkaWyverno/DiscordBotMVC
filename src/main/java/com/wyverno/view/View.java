package com.wyverno.view;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class View {
    public static void main(String[] args) throws LoginException, InterruptedException {
        Logger logger = LoggerFactory.getLogger(View.class);
        logger.info("Starting bot.");
        JDA jda = null;
        try {
            jda = JDABuilder.createDefault("token").build();
        } catch (LoginException e) {
            logger.error("Error loging Stacktrace:",e);
        }

        logger.info("Started bot.");
        logger.trace("Run");
        Thread.sleep(1000);
        logger.error("finish bot.");
        jda.shutdown();
    }

    public static int getInt() {
        return 5;
    }
}
