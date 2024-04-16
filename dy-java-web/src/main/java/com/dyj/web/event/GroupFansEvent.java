package com.dyj.web.event;

/**
 * im.group_fans.create_list
 * 用户加群成功
 */
public class GroupFansEvent {

    /**
     * 群主open_id
     */
    private String open_id;

    /**
     * 群ID
     */
    private String im_group_id;

    /**
     * 群操作类型 1-加群
     */
    private Integer group_type;

    /**
     * 建群类型，2-主播粉丝群，5万粉群
     */
    private Integer create_group_type;

    /**
     * 加群时间
     */
    private Long create_time;

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getIm_group_id() {
        return im_group_id;
    }

    public void setIm_group_id(String im_group_id) {
        this.im_group_id = im_group_id;
    }

    public Integer getGroup_type() {
        return group_type;
    }

    public void setGroup_type(Integer group_type) {
        this.group_type = group_type;
    }

    public Integer getCreate_group_type() {
        return create_group_type;
    }

    public void setCreate_group_type(Integer create_group_type) {
        this.create_group_type = create_group_type;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
}
