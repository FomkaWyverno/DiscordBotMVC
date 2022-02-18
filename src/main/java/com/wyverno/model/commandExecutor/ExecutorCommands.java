package com.wyverno.model.commandExecutor;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorCommands implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorCommands.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(8);

    static {

    }

    @Override
    public void run() {

    }

    private static void executeCommand(MessageReceivedEvent messageEvent) {

    }

    public static void stopExecutorCommand() {
        try {
            TimeUnit.SECONDS.sleep(5);
            logger.info("Stop the executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.info("Tasks interrupted",e);
        } finally {
            if (!executorService.isTerminated()) {
                logger.warn("Cancel non-finished tasks!");
            }
            executorService.shutdownNow();
            logger.info("Shutdown the executor finished");
        }

    }


}
