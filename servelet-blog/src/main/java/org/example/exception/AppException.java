package org.example.exception;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 17:11
 **/
/*
* 自定义异常类:业务代码跑自定义异常或者其他异常
* 自定义异常返回给定的错误码，其他异常返回其他塔错误码
* */
public class AppException extends RuntimeException{
    //
    private String code;
    public AppException(String code,String message) {
        super(message);//先调用父类的构造方法。构建出来了子类对象
        this.code=code;

    }

    public AppException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
