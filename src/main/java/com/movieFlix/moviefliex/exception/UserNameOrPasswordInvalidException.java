package com.movieFlix.moviefliex.exception;

public class UserNameOrPasswordInvalidException extends RuntimeException {

    public UserNameOrPasswordInvalidException(String message) {
      super(message);
    }
}
