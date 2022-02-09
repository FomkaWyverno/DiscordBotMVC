package com.wyverno.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Logger logger = LoggerFactory.getLogger("file");
        for (int i = 0; i < 10000; i++) {
            logger.info("Hello world");
        }
    }
}
