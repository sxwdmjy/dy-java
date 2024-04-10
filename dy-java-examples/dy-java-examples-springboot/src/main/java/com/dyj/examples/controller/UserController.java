package com.dyj.examples.controller;

import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.handler.RequestHandler;
import com.dyj.web.DyWebClient;
import com.dyj.web.client.AuthClient;
import com.dyj.web.client.VideoClient;
import com.dyj.web.domain.vo.AccessTokenVo;
import com.dyj.web.domain.vo.CheckFansVo;
import com.dyj.web.domain.vo.UserInfoVo;
import com.dyj.web.domain.vo.UserRoleCheckVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author danmo
 * @date 2024-04-02 18:37
 **/
@RestController
@RequestMapping("/")
public class UserController {


    @Resource
    private DyConfiguration dyConfiguration;

    @Resource
    private AuthClient authClient;

    @Resource
    private VideoClient videoClient;

    @RequestMapping("test")
    public void test(String accessToken) {
        DyConfiguration dyConfiguration = RequestHandler.getInstance().getDyConfiguration();
        dyConfiguration.getAgentTokenService().setTokenInfo(1, "aw0nkq98bbkdvq7d", accessToken, 1296000L, "rft.0c65de79f8480fe686db016ca7f73f931n6mtIsPiKmvKCk5LiszMuuBJu1E", 2592000L, "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm");
    }

    @RequestMapping("/accessToken")
    public String accessToken(String code) {
        DyResult<AccessTokenVo> dyResult = DyWebClient.getInstance().tenantId(1).clientKey("aw0nkq98bbkdvq7d").accessToken(code);

        return dyResult.getData().getAccess_token();
    }

    @RequestMapping("/userInfo")
    public DyResult<UserInfoVo> userInfo(String openId) {
        return DyWebClient.getInstance().getUserInfo(openId);
    }

    @GetMapping("/checkFans")
    public DyResult<CheckFansVo> checkFans(String openId, String followerOpenId) {
        return DyWebClient.getInstance().checkFans(openId, followerOpenId);
    }

    @GetMapping("/userRoleCheck")
    public DyResult<UserRoleCheckVo> userRoleCheck(String openId) {
        return DyWebClient.getInstance().userRoleCheck(openId, null, Arrays.asList("STAFF"));
    }


}
