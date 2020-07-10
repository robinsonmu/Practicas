package com.prodigious.thrower;

import java.util.Random;

public class ExceptionThrower {

    public void throwRandomException() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        
        if (randomNumber < 20) {
            throwIllegalStateException(randomNumber);
        }
        else if (randomNumber >= 80) {
            throwRuntimeException(randomNumber);
        }
        else if (randomNumber >= 20 && randomNumber < 40) {
            System.out.println("No exception thrown here! Value: " + randomNumber);
        }
        else if (randomNumber >= 40 && randomNumber < 60) {
            throwCustomRuntimeException(randomNumber);
        }
        else {
            throwCustomCheckedException(randomNumber);
        }
    }
    
    private void throwIllegalStateException(int value) {
        throw new IllegalStateException("I'm throwing an IndexOutOfBoundsException. Value: " + value);
    }
    
    private void throwRuntimeException(int value) {
        throw new RuntimeException("I'm throwing a RuntimeException. Value: " + value);
    }
    
    private void throwCustomRuntimeException(int value) {
        //TODO Throw CustomRuntimeException
    }
    
    private void throwCustomCheckedException(int value) {
        //TODO Throw CustomCheckedException
    }
}
