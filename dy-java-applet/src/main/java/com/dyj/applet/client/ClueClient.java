package com.dyj.applet.client;

import com.dtflys.forest.annotation.*;
import com.dyj.applet.domain.query.CreateClueComponentQuery;
import com.dyj.applet.domain.query.UpdateClueComponentQuery;
import com.dyj.applet.domain.vo.ClueComponentVo;
import com.dyj.applet.domain.vo.CreateClueComponentVo;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.query.BaseQuery;
import com.dyj.common.interceptor.AppV2TokenHeaderInterceptor;

/**
 * @author danmo
 * @date 2024-04-18 15:09
 **/
@BaseRequest(baseURL = "${ttDomain}", interceptor = AppV2TokenHeaderInterceptor.class)
public interface ClueClient {

    /**
     * 创建线索组件
     *
     * @param query 创建入参
     * @return DySimpleResult<CreateClueComponentVo>
     */
    @Post(value = "${createClueComponent}")
    DySimpleResult<CreateClueComponentVo> createClueComponent(@JSONBody CreateClueComponentQuery query);

    /**
     * 查询已创建的线索组件
     *
     * @param query    应用信息
     * @param pageNo   分页游标，默认从1开始
     * @param pageSize 分页大小，取值范围[1,20]，默认值20
     * @return
     */
    @Get(value = "${queryClueComponent}")
    DySimpleResult<ClueComponentVo> queryClueComponent(@Var("query") BaseQuery query, @Query("page_no") Integer pageNo, @Query("page_size") Integer pageSize);

    /**
     * 更新线索组件
     *
     * @param query 更新入参
     * @return DySimpleResult
     */
    @Post(value = "${updateClueComponent}")
    DySimpleResult updateClueComponent(@JSONBody UpdateClueComponentQuery query);

    /**
     * 删除线索组件
     *
     * @param query    应用信息
     * @param configId 线索组件id
     * @return DySimpleResult
     */
    @Delete(value = "${deleteClueComponent}")
    DySimpleResult deleteClueComponent(@Var("query") BaseQuery query, @JSONBody("config_id") String configId);


}
