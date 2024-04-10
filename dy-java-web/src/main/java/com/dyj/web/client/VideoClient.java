package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;
import com.dyj.web.interceptor.ClientTokenInterceptor;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

import java.io.InputStream;

/**
 * @author danmo
 * @date 2024-04-07 18:47
 **/

@BaseRequest(baseURL = "${domain}")
public interface VideoClient {

    @Post(url = "${createImageText}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<CreateImageTextVo> createImageText(@JSONBody CreateImageTextQuery query);

    @Post(url = "${uploadImage}", contentType = ContentType.MULTIPART_FORM_DATA, interceptor = TokenHeaderInterceptor.class)
    DyResult<UploadImageVo> uploadImage(@Var("query") UserInfoQuery query, @DataFile(value = "image") InputStream inputStream);

    @Post(url = "${uploadVideo}", contentType = ContentType.MULTIPART_FORM_DATA, interceptor = TokenHeaderInterceptor.class)
    DyResult<UploadVideoVo> uploadVideo(@Var("query") UserInfoQuery query, @DataFile(value = "video") InputStream inputStream);


    @Post(url = "${createVideo}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<CreateVideoVo> createVideo(@JSONBody CreateVideoQuery query);

    @Post(url = "${completeVideoPartUpload}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<UploadVideoVo> completeVideoPartUpload(@Var("query") UserInfoQuery query, @Query("upload_id") String uploadId);

    @Post(url = "${uploadVideoPart}", contentType = ContentType.MULTIPART_FORM_DATA, interceptor = TokenHeaderInterceptor.class)
    DyResult<BaseVo> uploadVideoPart(@Var("query") UserInfoQuery query, @Query("upload_id") String uploadId, @Query("part_number") Integer partNumber, @DataFile(value = "video") InputStream inputStream);

    @Post(url = "${initializeVideoPartUpload}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<InitPartUploadVo> initializeVideoPartUpload(@Var("query") UserInfoQuery query);

    @Get(url = "${queryVideoList}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<QueryVideoListVo> queryVideoList(@Var("query") UserInfoQuery query, @Query("cursor") Integer cursor, @Query("count") Integer count);

    @Post(url = "${queryVideoData}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
    DyResult<QueryVideoListVo> queryVideoData(@JSONBody VideoDataQuery query);

    @Get(url = "${queryVideoPublishResult}", contentType = ContentType.APPLICATION_JSON, interceptor = ClientTokenInterceptor.class)
    DyResult<QueryVideoPublishResultVo> queryVideoPublishResult(@JSONBody BaseQuery query, @Query("default_hashtag") String defaultHashtag, @Query("link_param") String linkParam, @Query("need_callback") Boolean needCallback, @Query("source_style_id") String sourceStyleId);

    @Get(url = "${queryVideoLocation}", contentType = ContentType.APPLICATION_JSON, interceptor = ClientTokenInterceptor.class)
    DyResult<QueryVideoLocationVo> queryVideoLocation(@JSONBody BaseQuery query, @Query("count") Integer count, @Query("keyword") String keyword, @Query("city") String city, @Query("cursor") Integer cursor);

    @Get(url = "${queryVideoIframe}", contentType = ContentType.APPLICATION_JSON)
    DyResult<VideoIframeVo> getIframeByVideo(@Query("video_id") String videoId);

    @Get(url = "${queryVideoIframeByItem}", contentType = ContentType.APPLICATION_JSON)
    DyResult<VideoIframeVo> getIframeByItem(@Query("item_id") String itemId, @Query("client_key") String clientKey);
}
