package com.dyj.examples.controller;

import com.dyj.common.config.DyConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.client.AuthClient;
import com.dyj.web.domain.query.DyAccessTokenQuery;
import com.dyj.web.domain.vo.DyAccessTokenVo;
import org.springframework.beans.factory.annotation.Autowired;
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
        DyResult<DyAccessTokenVo> accessToken = authClient.getAccessToken(new DyAccessTokenQuery());
        return dyConfiguration.getBeanId();
    }



}
