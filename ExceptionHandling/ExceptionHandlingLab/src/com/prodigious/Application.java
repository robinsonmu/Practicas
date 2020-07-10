package com.prodigious;

import com.prodigious.thrower.ExceptionThrower;

public class Application {

    public static void main(String[] args) {
        
        ExceptionThrower thrower = new ExceptionThrower();
        
        for (int iteration = 0; iteration < 10; iteration++) {
            thrower.throwRandomException();
        }
    }
}