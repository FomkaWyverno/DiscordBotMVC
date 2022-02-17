package com.wyverno.controller;

import com.wyverno.model.Model;
import com.wyverno.patterns.observer.Observer;


public abstract class Controller implements Observer {

    protected final Model MODEL;

    public Controller(Model model) {
        this.MODEL = model;
    }

    public abstract void update(Object observable, Object arg);
}
