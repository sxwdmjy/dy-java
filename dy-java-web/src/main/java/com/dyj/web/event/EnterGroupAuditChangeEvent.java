package com.dyj.web.event;

/**
 * im.group_fans.create_list
 * 用户加群申请
 */
public class EnterGroupAuditChangeEvent {

    /**
     * 群ID，群唯一标识
     */
    private String group_id;

    /**
     * 审批单id
     */
    private String apply_id;

    /**
     * 用户头像
     */
    private String user_avatar;

    /**
     * 用户申请状态 1-申请中，2-同意，3-拒绝
     */
    private Integer apply_status;

    /**
     * 用户昵称
     */
    private String user_nicker;

    private Long create_time;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public Integer getApply_status() {
        return apply_status;
    }

    public void setApply_status(Integer apply_status) {
        this.apply_status = apply_status;
    }

    public String getUser_nicker() {
        return user_nicker;
    }

    public void setUser_nicker(String user_nicker) {
        this.user_nicker = user_nicker;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
}
