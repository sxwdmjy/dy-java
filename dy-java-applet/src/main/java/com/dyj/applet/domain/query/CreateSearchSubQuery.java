package com.dyj.applet.domain.query;

import com.dyj.common.domain.query.BaseQuery;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-22 18:46
 **/
public class CreateSearchSubQuery extends BaseQuery {

    /**
     * 该子服务可用于检索的关键词，例如您打算创建一个宝宝起名服务，
     * 而用户可能会通过搜索「起名」，「宝宝起名」等字眼来找到对应的小程序功能，
     * 您就可以将关键词设置为「起名」，「宝宝起名」等字眼，
     * 方便用户更容易直接搜索到您的小程序功能（关键词的个数为2～6个）（每个关键词的长度为2-20）
     */
    private List<String> search_key_word;

    /**
     * 对应功能服务页面的路径链接，若用户搜索到了您的小程序相应的功能服务，点击进入该服务，会跳转到您所传入的链接对应的页面中
     */
    private String start_page_url;
    /**
     * 搜索直达子服务的名称，例如有一个名为宝宝生成器的小程序，
     * 其中有一个功能是给宝宝起名字，那么此搜索直达子服务的名称就可以命名为「宝宝起名服务」（服务名称的长度为2-20）
     */
    private String sub_service_name;

    public List<String> getSearch_key_word() {
        return search_key_word;
    }

    public void setSearch_key_word(List<String> search_key_word) {
        this.search_key_word = search_key_word;
    }

    public String getStart_page_url() {
        return start_page_url;
    }

    public void setStart_page_url(String start_page_url) {
        this.start_page_url = start_page_url;
    }

    public String getSub_service_name() {
        return sub_service_name;
    }

    public void setSub_service_name(String sub_service_name) {
        this.sub_service_name = sub_service_name;
    }

    public static CreateSearchSubQueryBuilder builder() {
        return new CreateSearchSubQueryBuilder();
    }

    public static class CreateSearchSubQueryBuilder {

        private List<String> searchKeyWord;

        private String startPageUrl;

        private String subServiceName;

        private Integer tenantId;

        private String clientKey;

        public CreateSearchSubQueryBuilder searchKeyWord(List<String> searchKeyWord) {
            this.searchKeyWord = searchKeyWord;
            return this;
        }

        public CreateSearchSubQueryBuilder startPageUrl(String startPageUrl) {
            this.startPageUrl = startPageUrl;
            return this;
        }

        public CreateSearchSubQueryBuilder subServiceName(String subServiceName) {
            this.subServiceName = subServiceName;
            return this;
        }

        public CreateSearchSubQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreateSearchSubQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CreateSearchSubQuery build() {
            CreateSearchSubQuery createSearchSubQuery = new CreateSearchSubQuery();
            createSearchSubQuery.setSearch_key_word(searchKeyWord);
            createSearchSubQuery.setStart_page_url(startPageUrl);
            createSearchSubQuery.setSub_service_name(subServiceName);
            createSearchSubQuery.setTenantId(tenantId);
            createSearchSubQuery.setClientKey(clientKey);
            return createSearchSubQuery;
        }
    }
}
