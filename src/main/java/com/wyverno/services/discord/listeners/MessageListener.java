package com.wyverno.services.discord.listeners;

import com.wyverno.patterns.observer.Observable;
import com.wyverno.patterns.observer.Observer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListener extends ListenerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    private final Observable observable = new Observable();

    public void addObserver(Observer observer) {
        this.observable.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        this.observable.removeObserver(observer);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        logger.debug(String.format("Message Event [%s/%s]: %s",event.getGuild().getName(),
                                                                event.getAuthor().getName(),
                                                                event.getMessage().getContentRaw()));
        observable.notifyFromObservableObservers(this,event); // Оповещаем наблюдателя об ивенте
    }
}
