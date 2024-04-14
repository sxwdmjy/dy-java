package com.dyj.web.domain;

public class GroupMsgUserInfo {

    /**
     * 用户 open_id
     */
    private String open_id;
    /**
     * 用户昵称
     */
    private String nick_name;
    /**
     * 用户头像链接
     */
    private String avatar;

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
