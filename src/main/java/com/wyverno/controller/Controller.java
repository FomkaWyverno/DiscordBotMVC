package com.wyverno.controller;

import com.wyverno.model.Model;

public abstract class Controller {

    protected final Model MODEL;

    public Controller(Model model) {
        this.MODEL = model;
    }

    public abstract void stopProgram();
}
