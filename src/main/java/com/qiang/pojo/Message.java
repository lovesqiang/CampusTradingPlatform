package com.qiang.pojo;

public class Message {
    private Integer messageId;

    private Integer messageUserId;

    private String messageUserTel;

    private String messageContent;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(Integer messageUserId) {
        this.messageUserId = messageUserId;
    }

    public String getMessageUserTel() {
        return messageUserTel;
    }

    public void setMessageUserTel(String messageUserTel) {
        this.messageUserTel = messageUserTel == null ? null : messageUserTel.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }
}