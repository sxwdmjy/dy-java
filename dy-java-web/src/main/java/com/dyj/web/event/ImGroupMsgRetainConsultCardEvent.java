package com.dyj.web.event;

import com.dyj.web.domain.GroupMsgRetainConsultCardData;

import java.util.List;

/**
 * 留资卡片消息
 */
public class ImGroupMsgRetainConsultCardEvent extends ImGroupMsgEvent {

    private String card_id;

    /**
     * 1:空白态；2:完成态
     */
    private Integer card_status;

    /**
     * 留资数据
     */
    private List<GroupMsgRetainConsultCardData> card_data;


    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Integer getCard_status() {
        return card_status;
    }

    public void setCard_status(Integer card_status) {
        this.card_status = card_status;
    }

    public List<GroupMsgRetainConsultCardData> getCard_data() {
        return card_data;
    }

    public void setCard_data(List<GroupMsgRetainConsultCardData> card_data) {
        this.card_data = card_data;
    }
}
