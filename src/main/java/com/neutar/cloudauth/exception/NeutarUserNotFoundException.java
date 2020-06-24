package com.neutar.cloudauth.exception;

public class NeutarUserNotFoundException extends RuntimeException {
    static final String NEUTAR_USER_NOT_FOUND = "User not found! User name= ";

    public NeutarUserNotFoundException(String username) {
        super(NEUTAR_USER_NOT_FOUND + username);
    }
}
