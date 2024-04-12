package com.dyj.web.domain.query;

public class CreateFansGroupQuery extends UserInfoQuery {

    /**
     *  群头像
     */
    private String avatar_uri;
    /**
     *  群介绍
     */
    private String description;

    /**
     *  群名称
     */
    private String group_name;

    /**
     *  进群门槛-粉丝活跃度 0-无要求 1-是群主的活跃粉丝
     */
    private Integer active_fans;

    /**
     * 允许群成员邀请朋友 1-允许 其他-不允许
     */
    private Integer allow_invite;

    /**
     *  进群门槛-粉丝团等级 0-无要求 1-1级及以上 3-3级及以上 5-5级及以上 9-9级及以上 12-12级及以上 15-15级及以上 17-17级及以上 20-20级及以上
     */
    private Integer fans_limit;

    /**
     * 2 主播粉丝群  5 万粉群
     */
    private Integer group_type;

    /**
     * 1 直播同步 其他 不同步
     */
    private Integer live_auto_sync;

    /**
     * 1 作品同步 其他 不同步
     */
    private Integer item_auto_sync;

    /**
     * 1 开启进群审批 其他 不开启
     */
    private Integer open_audit_switch;

    /**
     * 进群门槛-关注条件 0-无要求 1-仅关注 7-关注我超过7天以上 30-关注我超过30天以上 60-关注我超过60天以上
     */
    private Integer relation_type;

    /**
     * 1 展示到个人主页 其他 不展示
     */
    private Integer show_at_profile;


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

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Integer getActive_fans() {
        return active_fans;
    }

    public void setActive_fans(Integer active_fans) {
        this.active_fans = active_fans;
    }

    public Integer getAllow_invite() {
        return allow_invite;
    }

    public void setAllow_invite(Integer allow_invite) {
        this.allow_invite = allow_invite;
    }

    public Integer getFans_limit() {
        return fans_limit;
    }

    public void setFans_limit(Integer fans_limit) {
        this.fans_limit = fans_limit;
    }

    public Integer getGroup_type() {
        return group_type;
    }

    public void setGroup_type(Integer group_type) {
        this.group_type = group_type;
    }

    public Integer getLive_auto_sync() {
        return live_auto_sync;
    }

    public void setLive_auto_sync(Integer live_auto_sync) {
        this.live_auto_sync = live_auto_sync;
    }

    public Integer getItem_auto_sync() {
        return item_auto_sync;
    }

    public void setItem_auto_sync(Integer item_auto_sync) {
        this.item_auto_sync = item_auto_sync;
    }

    public Integer getOpen_audit_switch() {
        return open_audit_switch;
    }

    public void setOpen_audit_switch(Integer open_audit_switch) {
        this.open_audit_switch = open_audit_switch;
    }

    public Integer getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(Integer relation_type) {
        this.relation_type = relation_type;
    }

    public Integer getShow_at_profile() {
        return show_at_profile;
    }

    public void setShow_at_profile(Integer show_at_profile) {
        this.show_at_profile = show_at_profile;
    }


    public static CreateFansGroupQuery Builder()
    {
        return new CreateFansGroupQuery();
    }


    public static class CreateFansGroupQueryBuilder {
        private Integer tenantId;
        private String clientKey;
        private String openId;
        private String avatarUri;
        private String groupName;
        private Integer activeFans;
        private Integer allowInvite;
        private Integer fansLimit;
        private Integer groupType;
        private Integer liveAutoSync;
        private Integer itemAutoSync;
        private Integer openAuditSwitch;
        private Integer relationType;
        private Integer showAtProfile;
        private String description;

        public CreateFansGroupQueryBuilder tenantId(Integer tenantId)
        {
            this.tenantId = tenantId;
            return this;
        }

        public CreateFansGroupQueryBuilder clientKey(String clientKey)
        {
            this.clientKey = clientKey;
            return this;
        }

        public CreateFansGroupQueryBuilder openId(String openId)
        {
            this.openId = openId;
            return this;
        }

        public CreateFansGroupQueryBuilder avatarUri(String avatarUri)
        {
            this.avatarUri = avatarUri;
            return this;
        }

        public CreateFansGroupQueryBuilder groupName(String groupName)
        {
            this.groupName = groupName;
            return this;
        }

        public CreateFansGroupQueryBuilder activeFans(Integer activeFans)
        {
            this.activeFans = activeFans;
            return this;
        }

        public CreateFansGroupQueryBuilder allowInvite(Integer allowInvite)
        {
            this.allowInvite = allowInvite;
            return this;
        }

        public CreateFansGroupQueryBuilder fansLimit(Integer fansLimit)
        {
            this.fansLimit = fansLimit;
            return this;
        }

        public CreateFansGroupQueryBuilder groupType(Integer groupType)
        {
            this.groupType = groupType;
            return this;
        }

        public CreateFansGroupQueryBuilder liveAutoSync(Integer liveAutoSync)
        {
            this.liveAutoSync = liveAutoSync;
            return this;
        }

        public CreateFansGroupQueryBuilder itemAutoSync(Integer itemAutoSync)
        {
            this.itemAutoSync = itemAutoSync;
            return this;
        }

        public CreateFansGroupQueryBuilder openAuditSwitch(Integer openAuditSwitch)
        {
            this.openAuditSwitch = openAuditSwitch;
            return this;
        }

        public CreateFansGroupQueryBuilder relationType(Integer relationType)
        {
            this.relationType = relationType;
            return this;
        }

        public CreateFansGroupQueryBuilder showAtProfile(Integer showAtProfile)
        {
            this.showAtProfile = showAtProfile;
            return this;
        }

        public CreateFansGroupQueryBuilder description(String description)
        {
            this.description = description;
            return this;
        }

        public CreateFansGroupQuery build()
        {
            CreateFansGroupQuery createFansGroupQuery = new CreateFansGroupQuery();
            createFansGroupQuery.setAvatar_uri(avatarUri);
            createFansGroupQuery.setDescription(description);
            createFansGroupQuery.setGroup_name(groupName);
            createFansGroupQuery.setActive_fans(activeFans);
            createFansGroupQuery.setAllow_invite(allowInvite);
            createFansGroupQuery.setFans_limit(fansLimit);
            createFansGroupQuery.setGroup_type(groupType);
            createFansGroupQuery.setLive_auto_sync(liveAutoSync);
            createFansGroupQuery.setItem_auto_sync(itemAutoSync);
            createFansGroupQuery.setOpen_audit_switch(openAuditSwitch);
            createFansGroupQuery.setRelation_type(relationType);
            createFansGroupQuery.setShow_at_profile(showAtProfile);
            createFansGroupQuery.setOpen_id(openId);
            createFansGroupQuery.setClientKey(clientKey);
            createFansGroupQuery.setTenantId(tenantId);
            return createFansGroupQuery;
        }
    }




}
