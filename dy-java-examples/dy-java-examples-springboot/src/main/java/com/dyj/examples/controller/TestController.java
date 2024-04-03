package com.dyj.examples.controller;

import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.common.config.DyConfiguration;
import com.dyj.web.client.AuthClient;
import com.dyj.web.domain.vo.AccessTokenVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


    @RequestMapping("/test")
    public String test() {
        //DyResult<AccessTokenVo> accessToken1 = new AccessTokenService(authClient).getAccessToken("123");
        //DyResult<AccessTokenVo> accessToken = authClient.getAccessToken(new AccessTokenQuery());
        DyResult<AccessTokenVo> accessTokenVoDyResult = DyWebClient.accessToken("123");
        return dyConfiguration.getBeanId();
    }



}
