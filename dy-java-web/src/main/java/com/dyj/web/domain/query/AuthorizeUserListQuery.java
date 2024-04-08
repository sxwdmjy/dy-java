package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-08 17:16
 **/
public class AuthorizeUserListQuery extends UserInfoQuery{

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

    public static AuthorizeUserListQuery build() {
        return new AuthorizeUserListQuery();
    }

    public AuthorizeUserListQuery pageNum(Integer page_num) {
        this.page_num = page_num;
        return this;
    }

    public AuthorizeUserListQuery pageSize(Integer page_size) {
        this.page_size = page_size;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorizeUserListQuery{" +
                "page_num=" + page_num +
                ", page_size=" + page_size +
                ", open_id='" + open_id + '\'' +
                ", tenantId=" + tenantId +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
