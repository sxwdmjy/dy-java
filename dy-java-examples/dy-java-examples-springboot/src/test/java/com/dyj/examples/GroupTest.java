package com.dyj.examples;


import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.GroupSettingTypeEnum;
import com.dyj.web.DyWebClient;
import com.dyj.common.domain.TextMsg;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.CreateFansGroupVo;
import com.dyj.web.domain.vo.FansGroupSettingVo;
import com.dyj.web.domain.vo.FansGroupVo;
import com.dyj.web.domain.vo.SetFansGroupEnterStatusVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class GroupTest {
    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";

    //创建粉丝群
    @Test
    void createFansGroup() {
        CreateFansGroupQuery query = CreateFansGroupQuery.builder()
                .openId(openId)
                .avatarUri("")
                .itemAutoSync(1)
                .fansLimit(100)
                .liveAutoSync(1)
                .showAtProfile(1)
                .description("测试群组")
                .relationType(0)
                .openAuditSwitch(0)
                .groupType(5)
                .groupName("测试群组")
                .build();
        CreateFansGroupVo fansGroup = DyWebClient.getInstance().createFansGroup(query);
        System.out.println(JSONObject.toJSONString(fansGroup));
    }

    //变更用户入群申请状态
    @Test
    void setFansGroupEnterStatus() {
        SetFansGroupEnterStatusQuery query = SetFansGroupEnterStatusQuery.builder().status(2).openId(openId).applyId("").build();
        SetFansGroupEnterStatusVo enterStatus = DyWebClient.getInstance().setFansGroupEnterStatus(query);
        System.out.println(JSONObject.toJSONString(enterStatus));
    }

    @Test
    void queryFansGroup() {
        FansGroupVo fansGroupVo = DyWebClient.getInstance().queryFansGroup(openId);
        System.out.println(JSONObject.toJSONString(fansGroupVo));
    }

    //发送群消息
    @Test
    void sendGroupMessage() {
        SendGroupMsgQuery query = SendGroupMsgQuery.builder()
                .groupId("")
                .content(TextMsg.builder().text("2321ewzs").build())
                .groupToken("")
                .openId(openId)
                .build();
        DyWebClient.getInstance().sendGroupMessage(query);
    }

    @Test
    void revokeGroupMessage() {
        System.out.println(DyWebClient.getInstance().revokeGroupMessage(RevokeGroupMsgQuery.builder().openId(openId).msgId("").build()));
    }

    //设置进群问候语&群公告
    @Test
    void queryFansGroupSetting() {
        FansGroupSettingQuery query = FansGroupSettingQuery.builder()
                .groupId("")
                .openId(openId)
                .msgList(Collections.singletonList(TextMsg.builder().text("啊范德萨打发").build()))
                .groupSettingType(GroupSettingTypeEnum.NOTICE).build();
        FansGroupSettingVo settingVo = DyWebClient.getInstance().queryFansGroupSetting(query);
        System.out.println(JSONObject.toJSONString(settingVo));
    }

    /**
     * 查询群主所在群的用户入群申请状态
     */
    @Test
    void queryFansGroupEnterStatus() {
        System.out.println(DyWebClient.getInstance().queryFansGroupEnterStatus(openId, 100, 0));
    }

    //取消进群问候语&群公告配置。
    @Test
    void cancelFansGroupSetting() {
        FansGroupSettingQuery query = FansGroupSettingQuery.builder()
                .groupId("")
                .openId(openId)
                .groupSettingType(GroupSettingTypeEnum.NOTICE).build();
        System.out.println(DyWebClient.getInstance().cancelFansGroupSetting(query));
    }

    //查询用户剩余建群额度
    @Test
    void queryFansGroupCount() {
        System.out.println(DyWebClient.getInstance().queryFansGroupCount(openId));
    }
}