package com.yiran.cloud.response;

import java.io.Serializable;

/**
 * Created by Ale on 2021/3/12
 */
public class ResponseData<T> implements Serializable {
    private int code = 200;
    private boolean success;
    private String massage = "";
    private T data;


    public ResponseData(){ }

    public T getData(){
        if(this.data == null){
            return null;
        }
        return this.data;
    }

    public boolean isSuccess(){
        return success;
    }

    public int getCode(){
        return this.code;
    }

    public String getMassage(){
        return this.massage;
    }

    public ResponseData<T> success(){
        return success(ResponseStatus.SUCCESS,true);
    }

    public ResponseData<T> success(ResponseStatus code,boolean success){
        return success(code,success,"");
    }

    public ResponseData<T> success(ResponseStatus code,boolean success,String message){
        return success(code,success,message,null);
    }

    public ResponseData<T> success(ResponseStatus status,boolean success,String message,T data){
        this.code = status.getCode();
        this.success = success;
        this.massage = massage;
        this.data = data;
        return this;
    }


    public ResponseData<T> error(){
        return error(ResponseStatus.Error,false,"请求失败");
    }

    public ResponseData<T> error(ResponseStatus status,boolean success,String massage){
        return error(status,success,massage,null);
    }

    public ResponseData<T> error(ResponseStatus status,boolean success,String massage,T data){
        this.code = status.getCode();
        this.success = success;
        this.massage = massage;
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", success=" + success +
                ", massage='" + massage + '\'' +
                ", data=" + data +
                '}';
    }
}
