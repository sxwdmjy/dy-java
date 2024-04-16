package com.dyj.examples;


import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.GetH5ShareQuery;
import com.dyj.web.domain.vo.SchemaShareVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class SchemaTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    private final String itemId = "";


    //H5分享跳转链接获取
    @Test
    void getH5Share() {
        DySimpleResult<SchemaShareVo> dySimpleResult = DyWebClient.getInstance().getH5Share(GetH5ShareQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dySimpleResult));
    }

    //个人页跳转链接获取
    @Test
    void getUserProfile() {
        DySimpleResult<SchemaShareVo> dySimpleResult = DyWebClient.getInstance().getUserProfile(openId, "", 1000L);
        System.out.println(JSONObject.toJSONString(dySimpleResult));
    }

    //个人会话页跳转链接获取
    @Test
    void getUserChat() {
        DySimpleResult<SchemaShareVo> dySimpleResult = DyWebClient.getInstance().getUserChat(openId, "", 1000L);
        System.out.println(JSONObject.toJSONString(dySimpleResult));
    }

    //视频详情页跳转链接获取
    @Test
    void getItem() {
        DySimpleResult<SchemaShareVo> dySimpleResult = DyWebClient.getInstance().getItem(itemId, "", 1000L);
        System.out.println(JSONObject.toJSONString(dySimpleResult));
    }

    //直播间页跳转链接获取
    @Test
    void getLive() {
        DySimpleResult<SchemaShareVo> dySimpleResult = DyWebClient.getInstance().getLive(openId, "", 1000L);
        System.out.println(JSONObject.toJSONString(dySimpleResult));
    }
}