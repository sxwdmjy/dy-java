package com.dyj.web.domain.query;

import com.dyj.common.domain.query.UserInfoQuery;

/**
 * @author danmo
 * @date 2024-04-08 17:16
 **/
public class AuthorizeUserListQuery extends UserInfoQuery {

    private Integer page_num;

    private Integer page_size;



    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public static AuthorizeUserListQueryBuilder builder() {
        return new AuthorizeUserListQueryBuilder();
    }

    public static class AuthorizeUserListQueryBuilder {
        private Integer pageNum;

        private Integer pageSize;

        private String openId;

        private String clientKey;

        private Integer tenantId;

        public AuthorizeUserListQueryBuilder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public AuthorizeUserListQueryBuilder pageSize(Integer pageSize) {
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
        public AuthorizeUserListQuery build() {
            AuthorizeUserListQuery authorizeUserListQuery = new AuthorizeUserListQuery();
            authorizeUserListQuery.setPage_num(pageNum);
            authorizeUserListQuery.setPage_size(pageSize);
            authorizeUserListQuery.setOpen_id(openId);
            authorizeUserListQuery.setClientKey(clientKey);
            authorizeUserListQuery.setTenantId(tenantId);
            return authorizeUserListQuery;
        }
    }



}
