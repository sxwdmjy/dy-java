package com.dyj.common.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-03 11:18
 **/
public class DyResult<T> {

    /**
     * 返回对象
     */
    private T data;

    private String message;
    /**
     * 错误码描述
     */
    private DyExtra extra;

    /**
     * 消息ID
     */
    private String messageId;

    /**
     * 消息ID列表
     */
    private List<String> msgList;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DyExtra getExtra() {
        return extra;
    }

    public void setExtra(DyExtra extra) {
        this.extra = extra;
    }


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<String> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<String> msgList) {
        this.msgList = msgList;
    }

    @Override
    public String toString() {
        return "DyResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", extra=" + extra +
                ", messageId='" + messageId + '\'' +
                ", msgList=" + msgList +
                '}';
    }
}
