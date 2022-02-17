package com.wyverno.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<Observer> observerList;

    public void addObserver(Observer observer) {
        if (observerList == null) observerList = new ArrayList<>();
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) {
        notifyFromObservableObservers(this,arg);
    }

    public void notifyFromObservableObservers(Object observableObject) {
        notifyFromObservableObservers(observableObject,null);
    }

    public void notifyFromObservableObservers(Object observableObject,Object arg) {
        if (observerList == null || observerList.size() == 0) return;

        for (Observer o : observerList) {
            o.update(observableObject, arg);
        }
    }
}
