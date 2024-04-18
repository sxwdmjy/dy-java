package com.dyj.applet.handler;

import com.dyj.applet.domain.query.CreateClueComponentQuery;
import com.dyj.applet.domain.query.UpdateClueComponentQuery;
import com.dyj.applet.domain.vo.ClueComponentVo;
import com.dyj.applet.domain.vo.CreateClueComponentVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-18 16:28
 **/
public class ClueHandler extends AbstractAppletHandler {

    public ClueHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 创建线索组件
     *
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param region     区域
     * @return DySimpleResult<CreateClueComponentVo>
     */
    public DySimpleResult<CreateClueComponentVo> createClueComponent(String categoryId, String configName, String region) {
        return getClueClient().createClueComponent(CreateClueComponentQuery.builder()
                .categoryId(categoryId)
                .configName(configName)
                .region(region)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * 创建线索组件
     *
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param regionList 区域
     * @return DySimpleResult<CreateClueComponentVo>
     */
    public DySimpleResult<CreateClueComponentVo> createClueComponent(String categoryId, String configName, List<String> regionList) {
        return getClueClient().createClueComponent(CreateClueComponentQuery.builder()
                .categoryId(categoryId)
                .configName(configName)
                .regionList(regionList)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * 查询线索组件
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return DySimpleResult<ClueComponentVo>
     */
    public DySimpleResult<ClueComponentVo> queryClueComponent(Integer pageNo, Integer pageSize) {
        return getClueClient().queryClueComponent(baseQuery(), pageNo, pageSize);
    }

    /**
     * 更新线索组件
     *
     * @param configId   配置id
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param region     区域
     * @return DySimpleResult
     */
    public DySimpleResult updateClueComponent(String configId, String categoryId, String configName, String region) {
        return getClueClient().updateClueComponent(UpdateClueComponentQuery.builder()
                .configId(configId)
                .categoryId(categoryId)
                .configName(configName)
                .region(region)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * 更新线索组件
     *
     * @param configId   配置id
     * @param categoryId 类目id
     * @param configName 配置名称
     * @param regionList 区域
     * @return DySimpleResult
     */
    public DySimpleResult updateClueComponent(String configId, String categoryId, String configName, List<String> regionList) {
        return getClueClient().updateClueComponent(UpdateClueComponentQuery.builder()
                .configId(configId)
                .categoryId(categoryId)
                .configName(configName)
                .regionList(regionList)
                .tenantId(agentConfiguration.getTenantId())
                .clientKey(agentConfiguration.getClientKey())
                .build());
    }

    /**
     * 删除线索组件
     *
     * @param configId 配置id
     * @return DySimpleResult
     */
    public DySimpleResult deleteClueComponent(String configId) {
        return getClueClient().deleteClueComponent(baseQuery(), configId);
    }
}
