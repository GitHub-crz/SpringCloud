package com.crz.springbootquartz.util;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/5/5 17:04
 */

public class CommonResult {
    public String info;
    public static CommonResult success(String s){
        String in="success"+s;
        CommonResult C=new CommonResult(in);
        return C;
    }
    public CommonResult(String S){
        this.info=S;
    }
}
