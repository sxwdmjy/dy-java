package com.dyj.web.domain;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 10:32
 **/
public class FansGroup {

    /**
     * 群ID
     */
    private String group_id;

    /**
     * 群名称
     */
    private String group_name;

    /**
     * 群头像
     */
    private String avatar_uri;

    /**
     * 群简介
     */
    private String description;

    /**
     * 群门槛
     * 无要求
     * 万粉
     */
    private List<String> entry_limit;

    /**
     * 群现有人数
     */
    private Integer exist_num;

    /**
     * 群类型
     * 2-主播粉丝群
     * 5-万粉群
     */
    private Integer group_type;

    /**
     * 群最大支持进入人数
     */
    private Integer max_num;

    /**
     * 群状态 Normal-正常
     * Ban-封禁
     * Full-已满
     */
    private Integer status;

    /**
     * 群标签
     */
    private List<String> tags;


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getAvatar_uri() {
        return avatar_uri;
    }

    public void setAvatar_uri(String avatar_uri) {
        this.avatar_uri = avatar_uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getEntry_limit() {
        return entry_limit;
    }

    public void setEntry_limit(List<String> entry_limit) {
        this.entry_limit = entry_limit;
    }

    public Integer getExist_num() {
        return exist_num;
    }

    public void setExist_num(Integer exist_num) {
        this.exist_num = exist_num;
    }

    public Integer getGroup_type() {
        return group_type;
    }

    public void setGroup_type(Integer group_type) {
        this.group_type = group_type;
    }

    public Integer getMax_num() {
        return max_num;
    }

    public void setMax_num(Integer max_num) {
        this.max_num = max_num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "FansGroup{" +
                "group_id='" + group_id + '\'' +
                ", group_name='" + group_name + '\'' +
                ", avatar_uri='" + avatar_uri + '\'' +
                ", description='" + description + '\'' +
                ", entry_limit=" + entry_limit +
                ", exist_num=" + exist_num +
                ", group_type=" + group_type +
                ", max_num=" + max_num +
                ", status=" + status +
                ", tags=" + tags +
                '}';
    }
}
