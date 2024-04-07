package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-07 14:56
 **/
public class UserInfoVo  extends BaseVo{

    /**
     * 用户在当前应用的唯一标识
     */
    private String open_id;

    /**
     * 用户在当前开发者账号下的唯一标识（未绑定开发者账号没有该字段）
     */
    private String union_id;

    private String avatar;

    private String avatar_larger;

    private String nickname;


    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_larger() {
        return avatar_larger;
    }

    public void setAvatar_larger(String avatar_larger) {
        this.avatar_larger = avatar_larger;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "open_id='" + open_id + '\'' +
                ", union_id='" + union_id + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
