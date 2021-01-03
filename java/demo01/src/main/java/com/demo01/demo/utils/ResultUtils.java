package com.demo01.demo.utils;

import org.springframework.util.ObjectUtils;
import com.demo01.demo.utils.Result;


/**
 * @author Charles
 * @version 1.0
 * @date 2020/6/16
 */
public class ResultUtils {

    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    public static Result<String> fileNotFound() {

        return error(-13,"文件丢失");
    }

    public static Result<String> userNotFound() {

        return error(-12,"该用户无法登录，请联系管理员");
    }

    public static Result<String> unAuthorized() {

        return error(-11,"unauthorized");
    }

    public static Result<String> invalidToken(){

        return error(-10,"无效的token");
    }

    public static Result<String> tokenExpired(){

        return error(-9,"token已过时");
    }

    public static Result<String> unAuth(){

        return error(-8,"该资源未授权");
    }

    public static Result<String> authFail(){

        return error(-7,"appId或者appSecret不正确");
    }

    public static Result<String> systemError(){

        return error(-1,"系统异常");
    }

    public static Result<String> badReuest(){

        return error(-2,"错误请求参数");
    }

    public static Result<String> notFound(){

        return error(-3,"找不到请求路径");
    }

    public static Result<String> connectionError(){

        return error(-4,"网络连接请求失败");
    }

    public static Result methodNotAllowed(){

        return error(-5,"不合法的请求方式");
    }

    public static Result<String> databaseError(){

        return error(-6,"数据库异常");
    }


//    public static PageResult pageResult(IPage<?> page){
//        PageResult result = new PageResult<>();
//        if(!ObjectUtils.isEmpty(page)){
////            result.setFirst(page.);
////            result.setLast(page.isLast());
//            result.setSize(page.getSize());
//            result.setCurrent(page.getCurrent());
//            result.setTotal(page.getTotal());
//            result.setPages(page.getPages());
//            result.setData(page.getRecords());
//        }
//        return result;
//    }
}
