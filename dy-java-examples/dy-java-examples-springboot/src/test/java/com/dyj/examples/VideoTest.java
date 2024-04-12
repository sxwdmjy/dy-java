package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.query.CreateVideoQuery;
import com.dyj.web.domain.vo.CreateImageTextVo;
import com.dyj.web.domain.vo.CreateVideoVo;
import com.dyj.web.domain.vo.UploadImageVo;
import com.dyj.web.domain.vo.UploadVideoVo;
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
    @Test
    public void createImageText() {
        CreateImageTextQuery query = CreateImageTextQuery.builder().build();
        DyResult<CreateImageTextVo> imageText = DyWebClient.getInstance().createImageText(query);
        System.out.println(JSONObject.toJSONString(imageText));
    }

    @Test
    public void uploadImage() throws IOException {
        File file = FileUtils.getFile("20240402102610.png");
        DyResult<UploadImageVo> uploadVideo = DyWebClient.getInstance().uploadImage(openId, file);
        System.out.println(JSONObject.toJSONString(uploadVideo));
    }

    @Test
    public void uploadVideo() throws IOException {
        File file = FileUtils.getFile("5bab3d14cf994ec924885f880fcfdd2c.mp4");
        DyResult<UploadVideoVo> uploadVideo = DyWebClient.getInstance().uploadVideo(openId, file);
        System.out.println(JSONObject.toJSONString(uploadVideo));
    }

    @Test
    public void createVideo() {
        DyResult<CreateVideoVo> video = DyWebClient.getInstance().createVideo(CreateVideoQuery.builder().build());
        System.out.println(JSONObject.toJSONString(video));
    }
}
