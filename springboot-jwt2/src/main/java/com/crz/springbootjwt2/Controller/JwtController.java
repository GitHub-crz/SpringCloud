package com.crz.springbootjwt2.Controller;

import com.crz.springbootjwt2.Entity.Users;
import com.crz.springbootjwt2.Service.userService;
import com.crz.springbootjwt2.Util.JwtHelper;
import com.crz.springbootjwt2.Vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/2 15:19
 */


@RestController
public class JwtController {
    @PostMapping("login")
    public ResultVo login(@RequestParam(value = "usernameOrEmail", required = true) String usernameOrEmail,
                          @RequestParam(value = "password", required = true) String password,
                          HttpServletRequest request) {
        Boolean is_email = MatcherUtil.matcherEmail(usernameOrEmail);
        Users user = new Users();
        if (is_email) {
            user.setEmail(usernameOrEmail);
        } else {
            user.setUsername(usernameOrEmail);
        }
        Users query_user = userService.get(user);
        if (query_user == null) {
            return ResultVOUtil.error("400", "用户名或邮箱错误");
        }
        //验证密码
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean is_password = encoder.matches(password, query_user.getPassword());
        if (!is_password) {
            //密码错误，返回提示
            return ResultVOUtil.error("400", "密码错误");
        }

        String jwtToken = JwtHelper.createJWT(query_user.getUsername(),
                query_user.getId(),
                query_user.getRole().toString(),
                audience.getClientId(),
                audience.getName(),
                audience.getExpiresSecond()*1000,
                audience.getBase64Secret());

        String result_str = "bearer;" + jwtToken;
        return ResultVOUtil.success(result_str);
    }
}
