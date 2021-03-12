package com.yiran.cloud.response;

/**
 * Created by Ale on 2021/3/12
 */
public enum ResponseStatus {
    SUCCESS(200),

    Error(1000);

    private int code;


    ResponseStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
