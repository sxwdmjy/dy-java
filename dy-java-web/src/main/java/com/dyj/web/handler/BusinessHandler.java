package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.client.BusinessClient;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;

import java.io.File;
import java.io.InputStream;

/**
 * @author danmo
 * @date 2024-04-10 11:23
 **/
public class BusinessHandler {

    private BusinessClient businessClient;

    private final AgentConfiguration agentConfiguration;

    {
        businessClient = SpringUtils.getBean(BusinessClient.class);
    }

    public BusinessHandler(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public SaveRetainConsultCardVo saveRetainConsultCard(SaveRetainConsultCardQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.saveRetainConsultCard(query);
    }

    public SaveRetainConsultCardVo deleteRetainConsultCard(SaveRetainConsultCardQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.deleteRetainConsultCard(query);
    }

    public RetainConsultCardVo getRetainConsultCard(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.getRetainConsultCard(query);
    }

    public DyResult<CreateAppletTemplateVo> setAppletTemplate(CreateAppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.setAppletTemplate(query);
    }

    public DyResult<AppletTemplateVo> getAppletTemplate(AppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.getAppletTemplate(query);
    }

    public DyResult<BaseVo> delAppletTemplate(AppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return businessClient.delAppletTemplate(query);
    }

    public ImageClientUploadVo imageClientUpload(File file) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return businessClient.imageClientUpload(query, file);
    }

    public ImageClientUploadVo imageClientUpload(InputStream inputStream) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return businessClient.imageClientUpload(query, inputStream);
    }

    public ImageClientUploadVo imageClientUpload(Byte[] bytes) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return businessClient.imageClientUpload(query, bytes);
    }

}
