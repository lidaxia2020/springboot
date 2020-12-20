package com.security.learn4.common;

import org.springframework.security.core.AuthenticationException;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/20 15:15
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     *
     */
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
