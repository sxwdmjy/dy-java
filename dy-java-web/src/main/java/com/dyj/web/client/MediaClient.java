package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.MaterialListVo;
import com.dyj.web.domain.vo.UploadMaterialVo;
import com.dyj.web.interceptor.QueryTokenInterceptor;

/**
 * 素材管理
 *
 * @author danmo
 * @date 2024-04-11 14:55
 **/

@BaseRequest(baseURL = "${domain}")
public interface MediaClient {

    /**
     * 上传素材接口
     *
     * @param query 用户信息
     * @param bytes  文件素材
     * @return DyResult<UploadMaterialVo>
     */
    @Post(url = "${uploadMaterial}", contentType = ContentType.MULTIPART_FORM_DATA, interceptor = QueryTokenInterceptor.class)
    DyResult<UploadMaterialVo> uploadMaterial(@Var("query") UserInfoQuery query, @Body("media") byte[] bytes);


    /**
     * 上传临时素材接口
     * @param query 用户信息
     * @param bytes 文件素材
     * @return DyResult<UploadMaterialVo>
     */
    @Post(url = "${uploadTemporaryMaterial}", contentType = ContentType.MULTIPART_FORM_DATA, interceptor = QueryTokenInterceptor.class)
    DyResult<UploadMaterialVo> uploadTemporaryMaterial(@Var("query") UserInfoQuery query, @Body("media") byte[] bytes);

    /**
     * 素材列表接口
     * @param query 用户信息
     * @param cursor  cursor
     * @param count 数量
     * @return DyResult<MaterialListVo>
     */
    @Get(url = "${queryMaterialList}", contentType = ContentType.APPLICATION_JSON, interceptor = QueryTokenInterceptor.class)
    DyResult<MaterialListVo> queryMaterialList(@Var("query") UserInfoQuery query, @Query Integer cursor, @Query Integer count);

    /**
     * 删除素材接口
     * @param query 用户信息
     * @param mediaId 素材ID
     * @return DyResult<BaseVo>
     */
    @Post(url = "${deleteMaterial}", contentType = ContentType.APPLICATION_JSON, interceptor = QueryTokenInterceptor.class)
    DyResult<BaseVo> deleteMaterial(@Var("query") UserInfoQuery query, @Body("media_id") String mediaId);
}
