package com.dyj.examples.web;

import com.alibaba.fastjson.JSON;
import com.dyj.common.client.BaseClient;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.UserTokenInfo;
import com.dyj.common.exception.AuthTokenNotFoundException;
import com.dyj.common.service.IAgentConfigService;
import com.dyj.common.utils.DyConfigUtils;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.spring.properties.DyConfigurationProperties;
import com.dyj.spring.utils.SpringUtils;
import com.dyj.web.DyWebClient;
import com.dyj.common.domain.vo.AccessTokenVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    private final String code = "da8498f3b54aa903tW0CQSPYDGSFlb3c7ih4_lf";
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
     * 获取用户视频情况
     */
    @Test
    public void externalUserItem(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserItem(1L,openId)));
    }

    /**
     * 获取用户粉丝数
     */
    @Test
    public void externalUserFans(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserFans(1L,openId)));
    }

    /**
     * 获取用户点赞数
     */
    @Test
    public void externalUserLike(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserLike(1L,openId)));
    }

    /**
     * 获取用户评论数
     */
    @Test
    public void externalUserComment(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserComment(1L,openId)));
    }

    /**
     * 获取用户分享数
     */
    @Test
    public void externalUserShare(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserShare(1L,openId)));
    }

    /**
     * 获取用户主页访问数
     */
    @Test
    public void externalUserProfile(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalUserProfile(1L,openId)));
    }

    /**
     * 获取视频基础数据
     */
    @Test
    public void externalItemBase(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalItemBase("",openId)));
    }

    /**
     * 获取视频点赞数据
     */
    @Test
    public void externalItemLike(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalItemLike(1L,"",openId)));
    }

    /**
     * 获取视频评论数据
     */
    @Test
    public void externalItemComment(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalItemComment(1L,"",openId)));
    }

    /**
     * 获取视频播放数据
     */
    @Test
    public void externalItemPlay(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalItemPlay(1L,"",openId)));
    }

    /**
     * 获取视频播放数据
     */
    @Test
    public void externalItemShare(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.externalItemShare(1L,"",openId)));
    }

    /**
     * 获取主播历史开播过的房间ID
     */
    @Test
    public void getRoomIdList(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getRoomIdList(1L, openId,1L)));
    }

    /**
     * 获取直播间互动数据
     */
    @Test
    public void getRoomInteractiveData(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getRoomInteractiveData(1L, openId,1L)));
    }

    /**
     * 获取直播间看播数据
     */
    @Test
    public void getRoomAudienceData(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getRoomAudienceData(1L, openId,1L)));
    }

    /**
     * 获取直播间基础数据
     */
    @Test
    public void getRoomBaseData(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getRoomBaseData(1L, openId,1L)));
    }

    /**
     * 获取用户粉丝数据
     */
    @Test
    public void apiFansDataBind(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.apiFansDataBind(openId)));
    }

    /**
     * 获取用户粉丝来源
     */
    @Test
    public void getFansSource(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getFansSource(openId)));
    }

    /**
     * 获取用户粉丝喜好
     */
    @Test
    public void getFansFavourite(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getFansFavourite(openId)));
    }

    /**
     * 获取用户粉丝热评
     */
    @Test
    public void getFansComment(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.getFansComment(openId)));
    }

    /**
     * 获取实时热点词
     */
    @Test
    public void hotSentences(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.hotSentences()));
    }

    /**
     * 获取上升词
     */
    @Test
    public void trendingSentences(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.trendingSentences(1,null)));
    }

    /**
     * 获取热点词聚合的视频
     */
    @Test
    public void hotVideoList(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.hotVideoList("")));
    }

    /**
     * 获取抖音星图达人热榜
     */
    @Test
    public void starHotlist(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.starHotlist(1L)));
    }

    /**
     * 获取抖音星图达人指数
     */
    @Test
    public void starAuthorScore(){
        DyWebClient webClient = getAccessToken();
        
        System.out.println(JSON.toJSONString(webClient.starAuthorScore(openId)));
    }

    /**
     * 获取抖音星图达人指数数据V2
     */
    @Test
    public void starAuthorScoreV2(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.starAuthorScoreV2("")));
    }

    /**
     * 获取抖音电影榜、抖音电视剧榜、抖音综艺榜
     */
    @Test
    public void discoveryEntRankItem(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.discoveryEntRankItem(1L,1L)));
    }
    
    /**
     * 获取抖音影视综榜单版本
     */
    @Test
    public void discoveryEntRankVersion(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.discoveryEntRankVersion(1L,null,1L)));
    }

    /**
     * 热门视频榜
     */
    @Test
    public void getHotVideoBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getHotVideoBillboard()));
    }

    /**
     * 体育总榜
     */
    @Test
    public void sportOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportOverallBillboard()));
    }

    /**
     * 篮球榜
     */
    @Test
    public void sportBasketballBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportBasketballBillboard()));
    }

    /**
     * 足球榜
     */
    @Test
    public void sportSoccerBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportSoccerBillboard()));
    }

    /**
     * 综合体育榜
     */
    @Test
    public void sportComprehensiveBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportComprehensiveBillboard()));
    }

    /**
     * 运动健身榜
     */
    @Test
    public void sportFitnessBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportFitnessBillboard()));
    }

    /**
     * 户外运动榜
     */
    @Test
    public void sportOutdoorsBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportOutdoorsBillboard()));
    }

    /**
     * 台球榜
     */
    @Test
    public void sportTableTennisBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportTableTennisBillboard()));
    }

    /**
     * 运动文化榜
     */
    @Test
    public void sportCultureEBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.sportCultureEBillboard()));
    }

    /**
     * 搞笑总榜
     */
    @Test
    public void amusementOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.amusementOverallBillboard()));
    }

    /**
     * 搞笑新势力榜
     */
    @Test
    public void amusementNewBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.amusementNewBillboard()));
    }

    /**
     * 单机主机榜
     */
    @Test
    public void gameConsoleBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.gameConsoleBillboard()));
    }

    /**
     * 游戏资讯榜
     */
    @Test
    public void gameInfBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.gameInfBillboard()));
    }

    /**
     * 美食总榜
     */
    @Test
    public void foodOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.foodOverallBillboard()));
    }

    /**
     * 美食教程榜
     */
    @Test
    public void foodTutorialBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.foodTutorialBillboard()));
    }

    /**
     * 美食探店榜
     */
    @Test
    public void foodShopBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.foodShopBillboard()));
    }

    /**
     * 剧情总榜
     */
    @Test
    public void dramaOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.dramaOverallBillboard()));
    }

    /**
     * 汽车总榜
     */
    @Test
    public void carOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.carOverallBillboard()));
    }

    /**
     * 评车
     */
    @Test
    public void carCommentBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.carCommentBillboard()));
    }

    /**
     * 玩车
     */
    @Test
    public void carPlayBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.carPlayBillboard()));
    }

    /**
     * 用车
     */
    @Test
    public void carUseBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.carUseBillboard()));
    }
    /**
     * 驾考
     */
    @Test
    public void carDriverBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.carDriverBillboard()));
    }

    /**
     * 旅游总榜单
     */
    @Test
    public void travelOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.travelOverallBillboard()));
    }
    /**
     * 旅游新势力榜
     */
    @Test
    public void travelNewBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.travelNewBillboard()));
    }

    /**
     * 二次元总榜
     */
    @Test
    public void cospaOverallBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaOverallBillboard()));
    }

    /**
     * 轻漫
     */
    @Test
    public void cospaQingManBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaQingManBillboard()));
    }

    /**
     * 出境拍摄
     */
    @Test
    public void cospaOutShotBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaOutShotBillboard()));
    }

    /**
     * 绘画
     */
    @Test
    public void cospaPaintingBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaPaintingBillboard()));
    }

    /**
     * 声控
     */
    @Test
    public void cospaVoiceControlBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaVoiceControlBillboard()));
    }

    /**
     * 脑洞
     */
    @Test
    public void cospaBrainCavityBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaBrainCavityBillboard()));
    }

    /**
     * 二次元新势力榜
     */
    @Test
    public void cospaNewBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.cospaNewBillboard()));
    }

    /**
     * 娱乐明星榜
     */
    @Test
    public void getStarsBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getStarsBillboard()));
    }

    /**
     * 直播榜
     */
    @Test
    public void getLiveBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getLiveBillboard()));
    }

    /**
     * 热歌榜
     */
    @Test
    public void getHotMusicBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getHotMusicBillboard()));
    }

    /**
     * 飙升榜
     */
    @Test
    public void getSoarMusicBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getSoarMusicBillboard()));
    }

    /**
     * 原创榜
     */
    @Test
    public void getOriginalMusicBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getOriginalMusicBillboard()));
    }

    /**
     * 话题榜
     */
    @Test
    public void getTopicBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getTopicBillboard()));
    }

    /**
     * 道具榜
     */
    @Test
    public void getPropBillboard(){
        DyWebClient webClient = getAccessToken();
        System.out.println(JSON.toJSONString(webClient.getPropBillboard()));
    }


}
