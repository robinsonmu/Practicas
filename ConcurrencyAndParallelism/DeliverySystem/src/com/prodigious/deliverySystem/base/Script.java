package com.prodigious.deliverySystem.base;


public interface Script<T> {

    public void addCommand(Command<T> command);

    public void execute(T t);
}