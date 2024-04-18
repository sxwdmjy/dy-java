package com.dyj.web.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;
import com.dyj.common.enums.GroupSettingTypeEnum;
import com.dyj.common.domain.MsgContent;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 10:37
 **/
public class FansGroupSettingQuery extends UserInfoQuery {

    private String group_id;

    private GroupSettingTypeEnum group_setting_type;

    private List<MsgContent> msg_list;

    public static FansGroupSettingQueryBuilder builder() {
        return new FansGroupSettingQueryBuilder();
    }

    public static class FansGroupSettingQueryBuilder {
        private String groupId;
        private GroupSettingTypeEnum groupSettingType;
        private List<MsgContent> msgList;
        private String clientKey;
        private Integer tenantId;
        private String openId;

        public FansGroupSettingQueryBuilder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }
        public FansGroupSettingQueryBuilder groupSettingType(GroupSettingTypeEnum groupSettingType) {
            this.groupSettingType = groupSettingType;
            return this;
        }
        public FansGroupSettingQueryBuilder msgList(List<MsgContent> msgList) {
            this.msgList = msgList;
            return this;
        }

        public FansGroupSettingQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public FansGroupSettingQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public FansGroupSettingQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public FansGroupSettingQuery build() {
            return new FansGroupSettingQuery(this);
        }
    }

    public FansGroupSettingQuery() {
    }

    private FansGroupSettingQuery(FansGroupSettingQueryBuilder builder) {
        this.group_id = builder.groupId;
        this.group_setting_type = builder.groupSettingType;
        this.msg_list = builder.msgList;
        this.clientKey = builder.clientKey;
        this.tenantId = builder.tenantId;
        this.open_id = builder.openId;
    }
}
