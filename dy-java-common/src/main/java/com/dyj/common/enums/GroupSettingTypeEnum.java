package com.dyj.common.enums;

public enum GroupSettingTypeEnum {

    /**
     * 群问候语
     */
    WELCOME(1),

    /**
     * 群公告
     */
    NOTICE(2),

    ;

    private Integer type;

    GroupSettingTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
