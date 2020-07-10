package com.prodigious.deliverySystem.base;

@FunctionalInterface
public interface Command<T> {

    public void execute(T t);
}