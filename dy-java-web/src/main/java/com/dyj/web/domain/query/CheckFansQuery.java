package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-07 16:52
 **/
public class CheckFansQuery extends UserInfoQuery {

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

    public static CheckFansQueryBuilder builder() {
        return new CheckFansQueryBuilder();
    }

    public static class CheckFansQueryBuilder {
        private String followerOpenId;

        private String openId;

        private Integer tenantId;

        private String clientKey;

        public CheckFansQueryBuilder followerOpenId(String followerOpenId) {
            this.followerOpenId = followerOpenId;
            return this;
        }

        public CheckFansQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public CheckFansQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CheckFansQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CheckFansQuery build() {
            CheckFansQuery checkFansQuery = new CheckFansQuery();
            checkFansQuery.setFollower_open_id(followerOpenId);
            checkFansQuery.setOpen_id(openId);
            checkFansQuery.setTenantId(tenantId);
            checkFansQuery.setClientKey(clientKey);
            return checkFansQuery;
        }
    }

    @Override
    public String toString() {
        return "CheckFansQuery{" +
                "follower_open_id='" + follower_open_id + '\'' +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
