package com.dyj.applet.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 10:20
 **/
public class SendMsgResponseVo extends DyResult<BaseVo> {

    /**
     * 消息ID
     */
    public String msg_id;

    /**
     * 消息ID列表
     */
    public List<String> msg_list;


    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public List<String> getMsg_list() {
        return msg_list;
    }

    public void setMsg_list(List<String> msg_list) {
        this.msg_list = msg_list;
    }

}
