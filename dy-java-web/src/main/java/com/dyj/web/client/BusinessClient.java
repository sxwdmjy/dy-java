package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;
import com.dyj.web.interceptor.ClientTokenInterceptor;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

import java.io.File;
import java.io.InputStream;

/**
 * 经营工具
 * @author danmo
 * @date 2024-04-09 16:45
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface BusinessClient {

    /**
     * 创建/更新留资卡片
     * @param query
     * @return
     */
    @Post(value = "${saveRetainConsultCard}", interceptor = TokenHeaderInterceptor.class)
    SaveRetainConsultCardVo saveRetainConsultCard(@JSONBody SaveRetainConsultCardQuery query);

    /**
     * 查询留资卡片
     * @param query
     * @return
     */
    @Get(value = "${getRetainConsultCard}" ,interceptor = TokenHeaderInterceptor.class)
    RetainConsultCardVo getRetainConsultCard(@Var("query") UserInfoQuery query);

    /**
     * 删除留资卡片
     * @param query
     * @return
     */
    @Post(value = "${deleteRetainConsultCard}", interceptor = TokenHeaderInterceptor.class)
    SaveRetainConsultCardVo deleteRetainConsultCard(@JSONBody SaveRetainConsultCardQuery query);

    /**
     * 创建/更新小程序引导卡片模板
     * @param query
     * @return
     */
    @Post(value = "${setAppletTemplate}", interceptor = TokenHeaderInterceptor.class)
    DyResult<CreateAppletTemplateVo> setAppletTemplate(@JSONBody CreateAppletTemplateQuery query);

    /**
     * 查询小程序引导卡片模板
     */
    @Get(value = "${getAppletTemplate}", interceptor = TokenHeaderInterceptor.class)
    DyResult<AppletTemplateVo> getAppletTemplate(@JSONBody AppletTemplateQuery query);

    /**
     * 删除小程序引导卡片模板
     * @param query
     * @return
     */
    @Post(value = "${delAppletTemplate}", interceptor = TokenHeaderInterceptor.class)
    DyResult<BaseVo> delAppletTemplate(@JSONBody AppletTemplateQuery query);

    /**
     * 图片上传
     * @param query
     * @return
     */
    @Post(value = "${imageClientUpload}",contentType = ContentType.MULTIPART_FORM_DATA ,interceptor = ClientTokenInterceptor.class)
    ImageClientUploadVo imageClientUpload(@Var("query") BaseQuery query, @DataFile(value = "image",fileName = "image") File file);
    @Post(value = "${imageClientUpload}",contentType = ContentType.MULTIPART_FORM_DATA ,interceptor = ClientTokenInterceptor.class)
    ImageClientUploadVo imageClientUpload(@Var("query") BaseQuery query, @DataFile(value = "image",fileName = "image") InputStream inputStream);
    @Post(value = "${imageClientUpload}",contentType = ContentType.MULTIPART_FORM_DATA ,interceptor = ClientTokenInterceptor.class)
    ImageClientUploadVo imageClientUpload(@Var("query") BaseQuery query, @DataFile(value = "image",fileName = "image") byte[] bytes);



}
