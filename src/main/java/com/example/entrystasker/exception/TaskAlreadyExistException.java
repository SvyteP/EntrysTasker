package com.example.entrystasker.exception;

public class TaskAlreadyExistException extends Exception{
    public TaskAlreadyExistException(String message) {
        super(message);
    }
}
