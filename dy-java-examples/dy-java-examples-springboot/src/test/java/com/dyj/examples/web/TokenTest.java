package com.dyj.examples.web;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.AccessTokenVo;
import com.dyj.common.domain.vo.ClientTokenVo;
import com.dyj.common.domain.vo.RefreshAccessTokenVo;
import com.dyj.common.domain.vo.RefreshTokenVo;
import com.dyj.examples.DyJavaExamplesApplication;
import com.dyj.web.DyWebClient;
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
public class TokenTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    /**
     *
     * https://open.douyin.com/platform/oauth/connect?client_key=aw0nkq98bbkdvq7d&response_type=code&scope=user_info,fans.check,renew_refresh_token,trial.whitelist,video.data.bind,im.microapp_card,item.comment,jump.basic,data.external.item,live.room.base,live.room.interactive,live.room.audience,fans.data.bind&redirect_uri=https://www.douyin.com
     *
     * 暂时不能用的scope
     * im
     * enterprise.im
     * data.external.fans_favourite
     * data.external.fans_source
     * video.search.comment
     * video.search
     * user.intention
     * tool.image.upload
     * im.direct_message
     * im.recall_message
     * im.recall_message
     * im.group_message
     * im.group_fans.create_list
     * im.message_card
     * data.external.user
     *  授权连接获取code
     */

    /**
     * 获取access-token令牌
     */
    @Test
    public void accessToken() {
        String code = "b337e00580968712YW50EZoFrDfNPm03yzzh_hl";
        DyResult<AccessTokenVo> dyResult = DyWebClient.getInstance().accessToken(code);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 获取client-token令牌
     */
    @Test
    public void clientToken() {
        DyResult<ClientTokenVo> dyResult = DyWebClient.getInstance().clientToken();
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 刷新refresh-token令牌
     */
    @Test
    public void refreshToken() {
        DyResult<RefreshTokenVo> dyResult = DyWebClient.getInstance().refreshToken(openId);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 刷新access-token令牌
     */
    @Test
    public void refreshAccessToken() {
        DyResult<RefreshAccessTokenVo> dyResult = DyWebClient.getInstance().refreshAccessToken(openId);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

}
