package com.dyj.applet.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-19 14:05
 **/
public class TopCommentVo extends DyResult<BaseVo> {

    /**
     * 置顶评论用户头像
     */
    private String avatar;
    /**
     * 置顶评论用户昵称
     */
    private String nick_name;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
