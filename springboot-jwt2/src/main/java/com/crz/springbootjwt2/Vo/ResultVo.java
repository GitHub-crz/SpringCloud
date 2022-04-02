package com.crz.springbootjwt2.Vo;

import lombok.Data;

enum ResultCode {    //1000系列通用错误
    SUCCESS(1000, "操作成功"),
    FAILED(1001, "接口错误"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(1003, "未知错误"),
    //2000系列用户错误
    USER_NOT_EXIST(2000,"用户不存在"),
    USER_LOGIN_FAIL(2001,"用户名或密码错误"),
    USER_NOT_LOGIN(2002,"用户还未登录,请先登录"),
    NO_PERMISSION(2003,"权限不足,请联系管理员");
    private int code;
    private String msg;
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

@Data
public class ResultVo<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;
    public ResultVo(T data) {
        this(ResultCode.SUCCESS, data);
    }
    public ResultVo(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
