package com.dyj.examples.web;

import com.alibaba.fastjson.JSON;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.domain.vo.AccessTokenVo;
import com.dyj.common.exception.AuthTokenNotFoundException;
import com.dyj.common.service.IAgentConfigService;
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.VideoSearchCommentReplyV2Query;
import com.dyj.web.domain.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 搜索管理
 * @author ws
 * @date 2024-04-12 21:46
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class SearchTest {

    private final String openId = "_000oQUX6b7br2_T4fFcH3XIBeUqS_oUsOkn";

    private final String code = "da8498f3b54aa903vgtTGb4rNjvVz3wUvcBG_lf";
    /**
     *  https://open.douyin.com/platform/oauth/connect?client_key=aw0nkq98bbkdvq7d&response_type=code&scope=user_info,trial.whitelist&redirect_uri=https://www.douyin.com
     *  授权连接获取code
     */

    @Resource
    private IAgentConfigService agentConfigService;

    private DyWebClient getAccessToken() {
        DyWebClient webClient = DyWebClient.getInstance();
        webClient.tenantId = agentConfigService.loadAgentByTenantId(1).get(0).getTenantId();
        webClient.clientKey = agentConfigService.loadAgentByTenantId(1).get(0).getClientKey();
        UserTokenInfo userTokenInfo = null;
        try {
            userTokenInfo = DyConfigUtils.getAgentTokenService().getUserTokenInfo(webClient.tenantId, webClient.clientKey, openId);
        }catch (AuthTokenNotFoundException e){
            e.printStackTrace();
        }
        if (userTokenInfo == null){
            System.out.println(JSON.toJSONString(webClient.accessToken(code)));
        }
        return webClient;
    }

    /**
     * 关键词视频搜索
     */
    @Test
    public void videoSearchV2(){
        DyWebClient webClient = getAccessToken();
        DyResult<VideoSearchListVo> dyResult = webClient.videoSearchV2(openId,"123",1,null);
        System.out.println(JSON.toJSONString(dyResult));
    }

    /**
     * 关键词视频评论列表
     */
    @Test
    public void videoSearchCommentListV2(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.videoSearchCommentListV2(1,"1",null)));
    }

    /**
     * 关键词视频评论列表
     */
    @Test
    public void videoSearchCommentReplyV2(){
        DyWebClient webClient = getAccessToken();

        System.out.println(JSON.toJSONString(webClient.videoSearchCommentReplyV2(VideoSearchCommentReplyV2Query.builder().openId(openId).build())));
    }

    /**
     * 关键词视频评论回复列表
     */
    @Test
    public void videoSearchCommentReplyListV2(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.videoSearchCommentReplyListV2(null,1,"","")));
    }



}
