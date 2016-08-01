package com.ouyben.eventbusdemo;

/**
 * TODO : 传递消息的实体类
 * Created by owen on 2016-08-01.
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
