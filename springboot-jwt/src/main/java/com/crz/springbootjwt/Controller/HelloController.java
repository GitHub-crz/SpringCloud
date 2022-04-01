package com.crz.springbootjwt.Controller;

import com.crz.springbootjwt.Entity.Signin;
import com.crz.springbootjwt.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/test")
@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/hello")
    public String hello() {
        return "hello guys";
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody @ModelAttribute Signin signIn) {
        System.out.println(signIn.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword()));
            return jwtProvider.createToken(signIn.getUsername());
        } catch (AuthenticationException e) {
            System.out.println("Log in failed for user, " + signIn.getUsername());
        }

        return "";
    }

}
