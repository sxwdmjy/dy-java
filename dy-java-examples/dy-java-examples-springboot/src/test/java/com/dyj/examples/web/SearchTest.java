package com.dyj.examples.web;

import com.alibaba.fastjson.JSON;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.AccessTokenVo;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.VideoSearchCommentReplyV2Query;
import com.dyj.web.domain.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    private final String code = "da8498f3b54aa9030kZt9pCD17G1k9CKWpbv_lf";
    /**
     *  https://open.douyin.com/platform/oauth/connect?client_key=aw0nkq98bbkdvq7d&response_type=code&scope=user_info,trial.whitelist&redirect_uri=https://www.douyin.com
     *  授权连接获取code
     */

    /**
     * 关键词视频搜索
     */
    @Test
    public void videoSearchV2(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        DyResult<VideoSearchListVo> dyResult = webClient.videoSearchV2(openId,"1",1,null);
        System.out.println(JSON.toJSONString(dyResult));
    }

    /**
     * 关键词视频评论列表
     */
    @Test
    public void videoSearchCommentListV2(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.videoSearchCommentListV2(1,"1",null)));
    }

    /**
     * 关键词视频评论列表
     */
    @Test
    public void videoSearchCommentReplyV2(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.videoSearchCommentReplyV2(new VideoSearchCommentReplyV2Query())));
    }

    /**
     * 关键词视频评论回复列表
     */
    @Test
    public void videoSearchCommentReplyListV2(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.videoSearchCommentReplyListV2(null,1,"","")));
    }



}
