package com.example.Eventeam.exception;

public class MatchNotFoundException extends RuntimeException{
    public MatchNotFoundException(String message) {
        super(message);
    }
}
