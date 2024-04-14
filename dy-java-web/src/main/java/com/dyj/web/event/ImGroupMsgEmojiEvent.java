package com.dyj.web.event;

/**
 * 表情消息
 */
public class ImGroupMsgEmojiEvent extends ImGroupMsgEvent {

    /**
     * 资源类型 如:gif
     */
    private String resource_type;

    /**
     * 资源高度
     */
    private String resource_height;
    /**
     * 资源宽度
     */
    private String resource_width;

    /**
     * 资源链接
     */
    private String resource_url;


}
