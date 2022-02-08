package com.wyverno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello world");
    }
}
