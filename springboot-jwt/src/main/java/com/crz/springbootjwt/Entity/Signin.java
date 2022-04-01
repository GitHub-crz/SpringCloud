package com.crz.springbootjwt.Entity;

import com.sun.istack.internal.NotNull;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/1 16:02
 */

public class Signin {
    @NotNull
    private String username;

    @NotNull
    private String password;

    protected Signin() {}

    public Signin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
