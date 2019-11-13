package com.github.hellxz.security.exception;


import org.springframework.security.core.AuthenticationException;

public class NullUsernameException extends AuthenticationException {

    public NullUsernameException(String msg, Throwable t) {
        super(msg, t);
    }

    public NullUsernameException(String msg) {
        super(msg);
    }
}
