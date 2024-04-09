package com.dyj.common.enums;

public enum MediaTypeEnum {

    //文本
    TEXT(1),

    //图片
    IMAGE(2),

    //视频
    VIDEO(3),

    //留资卡片
    RETAIN_CONSULT_CARD(8),

    //小程序群聊邀请
    GROUP_INVITATION(9),

    //小程序卡片
    APPLET_CARD(10),

    //小程序优惠券
    APPLET_COUPON(11),

    auth_private_message_card(12)
    ;
    private final Integer type;


    MediaTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

}
