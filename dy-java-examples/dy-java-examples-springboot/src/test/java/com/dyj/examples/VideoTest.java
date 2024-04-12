package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.query.CreateVideoQuery;
import com.dyj.web.domain.query.VideoDataQuery;
import com.dyj.web.domain.vo.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author danmo
 * @date 2024-04-12 14:05
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class VideoTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    //创建图文消息
    @Test
    public void createImageText() {
        CreateImageTextQuery query = CreateImageTextQuery.builder().openId(openId).build();
        DyResult<CreateImageTextVo> imageText = DyWebClient.getInstance().createImageText(query);
        System.out.println(JSONObject.toJSONString(imageText));
    }

    //上传图片
    @Test
    public void uploadImage() throws IOException {
        File file = FileUtils.getFile("20240402102610.png");
        DyResult<UploadImageVo> uploadVideo = DyWebClient.getInstance().uploadImage(openId, file);
        System.out.println(JSONObject.toJSONString(uploadVideo));
    }

    //上传视频
    @Test
    public void uploadVideo() throws IOException {
        File file = FileUtils.getFile("5bab3d14cf994ec924885f880fcfdd2c.mp4");
        DyResult<UploadVideoVo> uploadVideo = DyWebClient.getInstance().uploadVideo(openId, file);
        System.out.println(JSONObject.toJSONString(uploadVideo));
    }

    //创建视频
    @Test
    public void createVideo() {
        DyResult<CreateVideoVo> video = DyWebClient.getInstance().createVideo(CreateVideoQuery.builder().openId(openId).build());
        System.out.println(JSONObject.toJSONString(video));
    }

    //分片上传完成
    @Test
    public void completeVideoPartUpdate() {
        DyResult<UploadVideoVo> baseVoDyResult = DyWebClient.getInstance().completeVideoPartUpdate(openId, "");
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //分片上传
    @Test
    public void updateVideoPart() throws IOException {
        File file = FileUtils.getFile("5bab3d14cf994ec924885f880fcfdd2c.mp4");
        DyResult<BaseVo> baseVoDyResult = DyWebClient.getInstance().updateVideoPart(openId, "", 10, file);
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //初始化分片上传
    @Test
    public void initializeVideoPartUpload(){
        DyResult<InitPartUploadVo> baseVoDyResult = DyWebClient.getInstance().initializeVideoPartUpload(openId);
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询授权账号视频列表
    @Test
    public void queryVideoList(){
        DyResult<QueryVideoListVo> baseVoDyResult = DyWebClient.getInstance().queryVideoList(openId, 1, 10);
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询特定视频的视频数据
    @Test
    public void queryVideoData(){
        DyResult<QueryVideoListVo> baseVoDyResult = DyWebClient.getInstance().queryVideoData(VideoDataQuery.builder().openId(openId).build());
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询视频发布结果
    @Test
    public void queryVideoPublishResult(){
        DyResult<QueryVideoPublishResultVo> baseVoDyResult = DyWebClient.getInstance().queryVideoPublishResult("hashtag", "", true, "");
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询视频携带的地点信息
    @Test
    public void queryVideoLocation(){
        DyResult<QueryVideoLocationVo> baseVoDyResult = DyWebClient.getInstance().queryVideoLocation(10, "情侣", "北京", null);
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询视频的IFRAME
    @Test
    public void getIframeByVideo(){
        DyResult<VideoIframeVo> baseVoDyResult = DyWebClient.getInstance().getIframeByVideo("");
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }

    //查询视频的IFRAME
    @Test
    public void getIframeByItem(){
        DyResult<VideoIframeVo> baseVoDyResult = DyWebClient.getInstance().getIframeByItem("");
        System.out.println(JSONObject.toJSONString(baseVoDyResult));
    }
}
