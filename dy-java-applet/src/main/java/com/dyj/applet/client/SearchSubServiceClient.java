package com.dyj.applet.client;

import com.dtflys.forest.annotation.*;
import com.dyj.applet.domain.query.CreateSearchSubQuery;
import com.dyj.applet.domain.vo.CheckSearchSubVo;
import com.dyj.applet.domain.vo.SearchSubListVo;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.common.interceptor.AppV2TokenHeaderInterceptor;

/**
 * 搜索能力
 *
 * @author danmo
 * @date 2024-04-22 15:09
 **/
@BaseRequest(baseURL = "${domain}")
public interface SearchSubServiceClient {

    /**
     * 删除抖音搜索直达子服务
     * @param query 应用信息
     * @param subServiceId 搜索直达子服务的id（搜索直达子服务的唯一标识）
     * @return DySimpleResult
     */
    @Post(url = "${deleteSearchSubService}", interceptor = AppV2TokenHeaderInterceptor.class)
    DySimpleResult<BaseVo> deleteSearchSubService(@Var("query") BaseQuery query, @JSONBody("sub_service_id") String subServiceId);

    /**
     * 校验是否有「搜索直达服务」的创建权限
     * @param query 应用信息
     * @return DySimpleResult
     */
    @Post(url = "${checkSearchSubService}", interceptor = AppV2TokenHeaderInterceptor.class)
    DySimpleResult<CheckSearchSubVo> checkSearchSubService(@Var("query") BaseQuery query);

    /**
     * 创建抖音搜索直达子服务
     * @param query 应用信息
     * @return DySimpleResult
     */
    @Post(url = "${createSearchSubService}", interceptor = AppV2TokenHeaderInterceptor.class)
    DySimpleResult<BaseVo> createSearchSubService(@JSONBody CreateSearchSubQuery query);

    /**
     * 查询已创建的抖音搜索直达子服务列表
     * @param query 应用信息
     * @param pageNo 查询的页号，从1开始
     * @param pageSize 查询一页的大小，从1开始
     * @param approvalState 要查询已创建服务的状态类型，0-审核中/1-已通过/2-未通过，传0就表示只查状态为审核中的服务，不传就表示查询全部状态的服务
     * @return DySimpleResult<SearchSubListVo>
     */
    @Get(url = "${querySearchSubService}", interceptor = AppV2TokenHeaderInterceptor.class)
    DySimpleResult<SearchSubListVo> querySearchSubService(@Var("query") BaseQuery query, @Query("page_no") Integer pageNo, @Query("page_size") Integer pageSize, @Query("approval_state") Long approvalState);
}
