package com.prodigious.deliverySystem.drons.utils;

public enum CardinalPoint {

    NORTH("N", "North"),
    SOUTH("S", "South"),
    EAST("E", "East"),
    WEST("W", "West");

    private String id;
    private String fullName;

    private CardinalPoint(String id, String fullName){
        this.id=id;
        this.fullName=fullName;
    }

    public String getFullName() {
        return fullName;
    }
}