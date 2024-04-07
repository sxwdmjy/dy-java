package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-07 16:52
 **/
public class CheckFansQuery extends UserInfoQuery{

    /**
     * 目标粉丝用户的 open_id
     */
    private String follower_open_id;

    public String getFollower_open_id() {
        return follower_open_id;
    }

    public void setFollower_open_id(String follower_open_id) {
        this.follower_open_id = follower_open_id;
    }
}
