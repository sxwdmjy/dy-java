package com.dyj.examples.web;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.vo.CheckFansVo;
import com.dyj.web.domain.vo.UserInfoVo;
import com.dyj.web.domain.vo.UserRoleCheckVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author danmo
 * @date 2024-04-12 10:11
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class UserTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    /**
     * 用户信息
     */
    @Test
    public void userInfo() {
        DyResult<UserInfoVo> userInfo = DyWebClient.getInstance()
                .getUserInfo(openId);
        System.out.println(JSONObject.toJSONString(userInfo));
    }

    @Test
    public void checkFans() {
        DyResult<CheckFansVo> checkFans = DyWebClient.getInstance()
                .checkFans(openId, "2132131");
        System.out.println(JSONObject.toJSONString(checkFans));
    }

    @Test
    public void getUserRoleCheck() {
        DyResult<UserRoleCheckVo> userInfo = DyWebClient.getInstance()
                .userRoleCheck(openId, "2132131", null);
        System.out.println(JSONObject.toJSONString(userInfo));
    }
}
