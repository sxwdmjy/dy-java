package com.dyj.examples;


import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.MaterialListVo;
import com.dyj.web.domain.vo.UploadMaterialVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class MediaTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    private final String mediaId = "";

    //上传素材
    @Test
    void uploadMaterial() throws IOException {
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadMaterial(new File(""));
        System.out.println(JSONObject.toJSONString(dyResult));
    }
    //上传素材
    @Test
    void testUploadMaterial() throws IOException {
        InputStream inputStream = Files.newInputStream(new File("").toPath());
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadMaterial(inputStream);
        System.out.println(JSONObject.toJSONString(dyResult));
    }
    //上传素材
    @Test
    void testUploadMaterial1() {
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadMaterial(new byte[]{});
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //上传临时素材
    @Test
    void uploadTemporaryMaterial() throws IOException {
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadTemporaryMaterial(new File(""));
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //上传临时素材
    @Test
    void testUploadTemporaryMaterial() {
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadTemporaryMaterial(new byte[]{});
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //上传临时素材
    @Test
    void testUploadTemporaryMaterial1() throws IOException {
        DyResult<UploadMaterialVo> dyResult = DyWebClient.getInstance().uploadTemporaryMaterial(Files.newInputStream(new File("").toPath()));
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //素材列表接口
    @Test
    void queryMaterialList() {
        DyResult<MaterialListVo> dyResult = DyWebClient.getInstance().queryMaterialList(openId, 0, 10);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //删除素材
    @Test
    void deleteMaterial() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().deleteMaterial(openId, mediaId);
        System.out.println(JSONObject.toJSONString(dyResult));
    }
}