package com.dyj.common.domain;

import com.dyj.common.enums.MediaTypeEnum;

/**
 * @author danmo
 * @date 2024-04-08 14:13
 **/
public class MsgContent {

    public MediaTypeEnum msg_type;

    public MediaTypeEnum getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(MediaTypeEnum msg_type) {
        this.msg_type = msg_type;
    }
}
