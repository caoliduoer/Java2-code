package org.example.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
* http相应jsoN数据，前后端统一约定的json格式
* 响应状态码是200，进入ajax的success来使用
* {success:true;}
*
* */
@Getter
@Setter
@ToString
public class JSONResponse {
//    业务操作是否成功
    private boolean success;
//    业务操作的消息码，一般来说，出现错误是的错误码才有意义，给开发人员定位问题
    private String code;
//    业务操作的错误信息，给用户看的
    private String message;
//    业务数据，业务操作成功时，给前端ajax success方法用的，解析响应json数据，渲染网页内
    private  Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
