package com.dyj.web.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-10 11:28
 **/
public class RetainConsultCard {

    /**
     * 留资卡片ID
     */
    private String card_id;
    /**
     * 卡片标题
     */
    private String title;
    /**
     * 素材ID
     */
    private String media_id;
    /**
     * 输入框
     * PhoneNo=1手机号
     * Name=2姓名
     * City=3城市
     */
    private List<Integer> components;

    /**
     * 审核状态
     * Pass=0通过
     * Reviewing=1审核中
     * Unpass=2不通过
     */
    private List<Integer> status;


    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public List<Integer> getComponents() {
        return components;
    }

    public void setComponents(List<Integer> components) {
        this.components = components;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RetainConsultCard{" +
                "card_id='" + card_id + '\'' +
                ", title='" + title + '\'' +
                ", media_id='" + media_id + '\'' +
                ", components=" + components +
                ", status=" + status +
                '}';
    }
}
