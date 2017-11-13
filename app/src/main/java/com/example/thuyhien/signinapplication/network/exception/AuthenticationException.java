package com.example.thuyhien.signinapplication.network.exception;

/**
 * Created by thuyhien on 11/13/17.
 */

public class AuthenticationException extends Exception{
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
