package com.dyj.web.domain.vo;

public class QueryVideoPublishResultVo extends BaseVo{

    private String share_id;

    public String getShare_id() {
        return share_id;
    }

    public void setShare_id(String share_id) {
        this.share_id = share_id;
    }

    @Override
    public String toString() {
        return "QueryVideoPublishResultVo{" +
                "share_id='" + share_id + '\'' +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}

