package com.bootmp2.bootmq2.pojo;

import lombok.Data;

import java.io.Serializable;


//@Data
public class Order implements Serializable {

    private String id;

    private String name;

    private String messageId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
