package com.wyverno.view;

import com.wyverno.model.Model;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class View {

    public static final Logger logger = LoggerFactory.getLogger(View.class);

    public static void main(String[] args) throws InterruptedException {
        JDA jda = Model.getJDA();
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        Model.stopJDA();
    }
}
