package com.dyj.applet.handler;

import com.dyj.applet.domain.query.CreateSearchSubQuery;
import com.dyj.applet.domain.vo.CheckSearchSubVo;
import com.dyj.applet.domain.vo.SearchSubListVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-22 19:01
 **/
public class SearchSubServiceHandler extends AbstractAppletHandler {

    public SearchSubServiceHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 删除抖音搜索直达子服务
     *
     * @param subServiceId 搜索直达子服务的id（搜索直达子服务的唯一标识）
     * @return DySimpleResult
     */
    public DySimpleResult<BaseVo> deleteSearchSubService(String subServiceId) {
        return getSearchSubServiceClient().deleteSearchSubService(baseQuery(), subServiceId);
    }

    /**
     * 校验是否有「搜索直达服务」的创建权限
     *
     * @return DySimpleResult<CheckSearchSubVo>
     */
    public DySimpleResult<CheckSearchSubVo> checkSearchSubService() {
        return getSearchSubServiceClient().checkSearchSubService(baseQuery());
    }

    /**
     * 创建抖音搜索直达子服务
     *
     * @param searchKeyWord  该子服务可用于检索的关键词
     * @param startPageUrl   对应功能服务页面的路径链接，若用户搜索到了您的小程序相应的功能服务，点击进入该服务，会跳转到您所传入的链接对应的页面中
     * @param subServiceName 搜索直达子服务的名称，例如有一个名为宝宝生成器的小程序，
     * @return DySimpleResult<BaseVo>
     */
    public DySimpleResult<BaseVo> createSearchSubService(List<String> searchKeyWord, String startPageUrl, String subServiceName) {
        return getSearchSubServiceClient().createSearchSubService(CreateSearchSubQuery.builder()
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .searchKeyWord(searchKeyWord)
                .startPageUrl(startPageUrl)
                .subServiceName(subServiceName)
                .build());
    }

    /**
     * 查询抖音搜索直达子服务
     *
     * @param pageNo        查询的页号，从1开始
     * @param pageSize      查询一页的大小，从1开始
     * @param approvalState 要查询已创建服务的状态类型，0-审核中/1-已通过/2-未通过，传0就表示只查状态为审核中的服务，不传就表示查询全部状态的服务
     * @return DySimpleResult<SearchSubListVo>
     */
    public DySimpleResult<SearchSubListVo> querySearchSubService(Integer pageNo, Integer pageSize, Long approvalState) {
        return getSearchSubServiceClient().querySearchSubService(baseQuery(), pageNo, pageSize, approvalState);
    }
}
