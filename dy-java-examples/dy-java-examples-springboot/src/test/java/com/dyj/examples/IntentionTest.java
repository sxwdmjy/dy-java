package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.IntentionLogQuery;
import com.dyj.web.domain.vo.IntentionLogVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author danmo
 * @date 2024-04-16 09:51
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class IntentionTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    //互动用户记录查询
    @Test
    public void intentionLog() {
        DyResult<IntentionLogVo> dyResult = DyWebClient.getInstance().intentionLog(IntentionLogQuery.builder().openId(openId).build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }
}
