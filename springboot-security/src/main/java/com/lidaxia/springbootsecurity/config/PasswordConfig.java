package com.lidaxia.springbootsecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:06（
 */
@Component
public class PasswordConfig implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        //定制加密算法，与存库时一致
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String password) {
        return password.contentEquals(charSequence);
    }
}