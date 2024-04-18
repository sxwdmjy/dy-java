package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

/**
 * @author danmo
 * @date 2024-04-08 17:16
 **/
public class ImAuthorizeUserListQuery extends UserInfoQuery {

    private Long page_num;

    private Long page_size;



    public Long getPage_num() {
        return page_num;
    }

    public void setPage_num(Long page_num) {
        this.page_num = page_num;
    }

    public Long getPage_size() {
        return page_size;
    }

    public void setPage_size(Long page_size) {
        this.page_size = page_size;
    }

    public static AuthorizeUserListQueryBuilder builder() {
        return new AuthorizeUserListQueryBuilder();
    }

    public static class AuthorizeUserListQueryBuilder {
        private Long pageNum;

        private Long pageSize;

        private String openId;

        private String clientKey;

        private Integer tenantId;

        public AuthorizeUserListQueryBuilder pageNum(Long pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public AuthorizeUserListQueryBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public AuthorizeUserListQueryBuilder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public AuthorizeUserListQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public AuthorizeUserListQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public ImAuthorizeUserListQuery build() {
            ImAuthorizeUserListQuery authorizeUserListQuery = new ImAuthorizeUserListQuery();
            authorizeUserListQuery.setPage_num(pageNum);
            authorizeUserListQuery.setPage_size(pageSize);
            authorizeUserListQuery.setOpen_id(openId);
            authorizeUserListQuery.setClientKey(clientKey);
            authorizeUserListQuery.setTenantId(tenantId);
            return authorizeUserListQuery;
        }
    }



}
