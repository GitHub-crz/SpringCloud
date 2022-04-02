package com.crz.springbootjwt2.Entity;

import lombok.Data;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/2 15:31
 */

@Data
public class Users {

    private String email;
    private String username;
    private String id;
    private String role;
}
