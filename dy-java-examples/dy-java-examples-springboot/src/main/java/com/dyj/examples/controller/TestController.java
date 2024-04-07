package com.dyj.examples.controller;

import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.common.config.DyConfiguration;
import com.dyj.web.client.AuthClient;
import com.dyj.web.client.VideoClient;
import com.dyj.web.domain.query.CreateImageTextQuery;
import com.dyj.web.domain.vo.AccessTokenVo;
import com.dyj.web.domain.vo.CreateImageTextVo;
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

    @Resource
    private VideoClient videoClient;


    @RequestMapping("/test")
    public String test() {
        CreateImageTextQuery createImageTextQuery = CreateImageTextQuery.build().tenantId(1).clientKey("213").open_id("1231231");
        DyResult<CreateImageTextVo> imageText = videoClient.createImageText(createImageTextQuery);
        System.out.println(imageText.toString());
        DyResult<AccessTokenVo> dyResult = DyWebClient.getInstance().tenantId(1).clientKey("123").accessToken("123");
        return dyResult.getData().getAccess_token();
    }



}
