package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.AppletTemplateQuery;
import com.dyj.web.domain.query.CreateAppletTemplateQuery;
import com.dyj.web.domain.query.SaveRetainConsultCardQuery;
import com.dyj.web.domain.vo.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class BusinessTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    //创建/更新留资卡片
    @Test
    void saveRetainConsultCard() {
        SaveRetainConsultCardVo consultCard = DyWebClient.getInstance().saveRetainConsultCard(SaveRetainConsultCardQuery.builder().build());
        System.out.println(JSONObject.toJSONString(consultCard));
    }

    //查询留资卡片
    @Test
    void getRetainConsultCard() {
        RetainConsultCardVo consultCard = DyWebClient.getInstance().getRetainConsultCard(openId);
        System.out.println(JSONObject.toJSONString(consultCard));
    }

    //删除留资卡片
    @Test
    void deleteRetainConsultCard() {
        SaveRetainConsultCardVo consultCard = DyWebClient.getInstance().deleteRetainConsultCard(SaveRetainConsultCardQuery.builder().build());
        System.out.println(JSONObject.toJSONString(consultCard));
    }

    //创建/更新小程序引导卡片模板
    @Test
    void setAppletTemplate() {
        DyResult<CreateAppletTemplateVo> dyResult = DyWebClient.getInstance().setAppletTemplate(CreateAppletTemplateQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //查询小程序引导卡片模板
    @Test
    void getAppletTemplate() {
        DyResult<AppletTemplateVo> dyResult = DyWebClient.getInstance().getAppletTemplate(AppletTemplateQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //删除小程序引导卡片模板
    @Test
    void delAppletTemplate() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().delAppletTemplate(AppletTemplateQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //上传图片
    @Test
    void imageClientUpload() {
        byte[] bytes = {};
        ImageClientUploadVo dyResult = DyWebClient.getInstance().imageClientUpload(bytes);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //上传图片
    @Test
    void testImageClientUpload() {
        ImageClientUploadVo dyResult = DyWebClient.getInstance().imageClientUpload(new File(""));
        System.out.println(JSONObject.toJSONString(dyResult));

    }

    //上传图片
    @Test
    void testImageClientUpload1() throws IOException {
        FileInputStream fileInputStream = FileUtils.openInputStream(new File(""));
        ImageClientUploadVo dyResult = DyWebClient.getInstance().imageClientUpload(fileInputStream);
        System.out.println(JSONObject.toJSONString(dyResult));
    }
}