package com.dyj.examples.controller;

import com.dyj.common.domain.DyResult;
import com.dyj.common.handler.RequestHandler;
import com.dyj.web.DyWebClient;
import com.dyj.common.config.DyConfiguration;
import com.dyj.web.client.AuthClient;
import com.dyj.web.client.VideoClient;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.vo.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author danmo
 * @date 2024-04-02 18:37
 **/
@RestController
@RequestMapping("/")
public class TestController {


    @Resource
    private DyConfiguration dyConfiguration;

    @Resource
    private AuthClient authClient;

    @Resource
    private VideoClient videoClient;

    @RequestMapping("test")
    public void test(){
        DyConfiguration dyConfiguration = RequestHandler.getInstance().getDyConfiguration();
        dyConfiguration.getAgentTokenService().setTokenInfo(1, "aw0nkq98bbkdvq7d", "act.3.4pp6AnTJDHvVoxcFhxxIZlJw-Ave3ujWmpECsQ4TftqXVdgRE7xU-IihP4ObsUT6dDUSfGY41bj0mkIICxY1dD2Fy_HekzgDx91rBRkff9dg7DU8Gwz6AM3v-XxsBqUJq5NFv7xA87PqUS4xK3Lnj1JH3d_0PPKv_35bPIZsN67vJPCuLa8RYrvR-08=", 1296000L, "rft.0c65de79f8480fe686db016ca7f73f931n6mtIsPiKmvKCk5LiszMuuBJu1E", 2592000L);
    }

    @RequestMapping("/accessToken")
    public String accessToken() {
        DyResult<AccessTokenVo> dyResult = DyWebClient.getInstance().tenantId(1).clientKey("aw0nkq98bbkdvq7d").accessToken("b337e00580968712Hrv33w2Cyr7RcOduHNly");

        return dyResult.getData().getAccess_token();
    }

    @RequestMapping("/userInfo")
    public  DyResult<UserInfoVo> userInfo() {
        return DyWebClient.getInstance().getUserInfo("_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm");
    }

    @GetMapping("/checkFans")
    public DyResult<CheckFansVo> checkFans() {
        return DyWebClient.getInstance().checkFans("_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm","_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm");
    }

    @GetMapping("/userRoleCheck")
    public DyResult<UserRoleCheckVo> userRoleCheck() {
        return DyWebClient.getInstance().userRoleCheck("_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm",null, Arrays.asList("STAFF"));
    }



}
