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
public class BusinessHandler extends AbstractWebHandler{


    public BusinessHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public SaveRetainConsultCardVo saveRetainConsultCard(SaveRetainConsultCardQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().saveRetainConsultCard(query);
    }

    public SaveRetainConsultCardVo deleteRetainConsultCard(SaveRetainConsultCardQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().deleteRetainConsultCard(query);
    }

    public RetainConsultCardVo getRetainConsultCard(String openId) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().getRetainConsultCard(query);
    }

    public DyResult<CreateAppletTemplateVo> setAppletTemplate(CreateAppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().setAppletTemplate(query);
    }

    public DyResult<AppletTemplateVo> getAppletTemplate(AppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().getAppletTemplate(query);
    }

    public DyResult<BaseVo> delAppletTemplate(AppletTemplateQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getBusinessClient().delAppletTemplate(query);
    }

    public ImageClientUploadVo imageClientUpload(File file) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return getBusinessClient().imageClientUpload(query, file);
    }

    public ImageClientUploadVo imageClientUpload(InputStream inputStream) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return getBusinessClient().imageClientUpload(query, inputStream);
    }

    public ImageClientUploadVo imageClientUpload(Byte[] bytes) {
        BaseQuery query = new BaseQuery();
        query.setClientKey(agentConfiguration.getClientKey());
        query.setTenantId(agentConfiguration.getTenantId());
        return getBusinessClient().imageClientUpload(query, bytes);
    }

}
