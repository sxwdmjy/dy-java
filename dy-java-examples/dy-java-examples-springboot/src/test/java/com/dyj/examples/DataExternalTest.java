package com.dyj.examples;

import com.alibaba.fastjson.JSON;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.common.domain.vo.AccessTokenVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 数据开放服务
 * @author ws
 * @date 2024-04-13 21:46
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class DataExternalTest {

    private final String openId = "_000oQUX6b7br2_T4fFcH3XIBeUqS_oUsOkn";

    private final String code = "da8498f3b54aa9030kZt9pCD17G1k9CKWpbv_lf";
    /**
     *  https://open.douyin.com/platform/oauth/connect?client_key=aw0nkq98bbkdvq7d&response_type=code&scope=user_info,trial.whitelist&redirect_uri=https://www.douyin.com
     *  授权连接获取code
     */

    /**
     * 获取用户视频情况
     */
    @Test
    public void externalUserItem(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserItem(1L,openId)));
    }

    /**
     * 获取用户粉丝数
     */
    @Test
    public void externalUserFans(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserFans(1L,openId)));
    }

    /**
     * 获取用户点赞数
     */
    @Test
    public void externalUserLike(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserLike(1L,openId)));
    }

    /**
     * 获取用户评论数
     */
    @Test
    public void externalUserComment(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserComment(1L,openId)));
    }

    /**
     * 获取用户分享数
     */
    @Test
    public void externalUserShare(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserShare(1L,openId)));
    }

    /**
     * 获取用户主页访问数
     */
    @Test
    public void externalUserProfile(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalUserProfile(1L,openId)));
    }

    /**
     * 获取视频基础数据
     */
    @Test
    public void externalItemBase(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalItemBase("",openId)));
    }

    /**
     * 获取视频点赞数据
     */
    @Test
    public void externalItemLike(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalItemLike(1L,"",openId)));
    }

    /**
     * 获取视频评论数据
     */
    @Test
    public void externalItemComment(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalItemComment(1L,"",openId)));
    }

    /**
     * 获取视频播放数据
     */
    @Test
    public void externalItemPlay(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalItemPlay(1L,"",openId)));
    }

    /**
     * 获取视频播放数据
     */
    @Test
    public void externalItemShare(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.externalItemShare(1L,"",openId)));
    }

    /**
     * 获取主播历史开播过的房间ID
     */
    @Test
    public void getRoomIdList(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getRoomIdList(1L, openId,1L)));
    }

    /**
     * 获取直播间互动数据
     */
    @Test
    public void getRoomInteractiveData(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getRoomInteractiveData(1L, openId,1L)));
    }

    /**
     * 获取直播间看播数据
     */
    @Test
    public void getRoomAudienceData(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getRoomAudienceData(1L, openId,1L)));
    }

    /**
     * 获取直播间基础数据
     */
    @Test
    public void getRoomBaseData(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getRoomBaseData(1L, openId,1L)));
    }

    /**
     * 获取用户粉丝数据
     */
    @Test
    public void apiFansDataBind(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.apiFansDataBind(openId)));
    }

    /**
     * 获取用户粉丝来源
     */
    @Test
    public void getFansSource(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getFansSource(openId)));
    }

    /**
     * 获取用户粉丝喜好
     */
    @Test
    public void getFansFavourite(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getFansFavourite(openId)));
    }

    /**
     * 获取用户粉丝热评
     */
    @Test
    public void getFansComment(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.getFansComment(openId)));
    }

    /**
     * 获取实时热点词
     */
    @Test
    public void hotSentences(){
        DyWebClient webClient = new DyWebClient();
        System.out.println(JSON.toJSONString(webClient.hotSentences()));
    }

    /**
     * 获取上升词
     */
    @Test
    public void trendingSentences(){
        DyWebClient webClient = new DyWebClient();
        System.out.println(JSON.toJSONString(webClient.trendingSentences(1,null)));
    }

    /**
     * 获取热点词聚合的视频
     */
    @Test
    public void hotVideoList(){
        DyWebClient webClient = new DyWebClient();
        System.out.println(JSON.toJSONString(webClient.hotVideoList("")));
    }

    /**
     * 获取抖音星图达人热榜
     */
    @Test
    public void starHotlist(){
        DyWebClient webClient = new DyWebClient();
        System.out.println(JSON.toJSONString(webClient.starHotlist(1L)));
    }

    /**
     * 获取抖音星图达人指数
     */
    @Test
    public void starAuthorScore(){
        DyWebClient webClient = new DyWebClient();
        DyResult<AccessTokenVo> accessToken = webClient.accessToken(code);
        System.out.println(JSON.toJSONString(accessToken));
        System.out.println(JSON.toJSONString(webClient.starAuthorScore(openId)));
    }

    /**
     * 获取抖音星图达人指数数据V2
     */
    @Test
    public void starAuthorScoreV2(){
        DyWebClient webClient = new DyWebClient();
        System.out.println(JSON.toJSONString(webClient.starAuthorScoreV2("")));
    }

}
