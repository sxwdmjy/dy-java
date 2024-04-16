package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.CommentQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.CommentListVo;
import com.dyj.web.domain.vo.CommentReplyVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class CommentTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    private final String itemId = "";
    private final String commentId = "";


    //评论置顶
    @Test
    void commentTop() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().commentTop(CommentQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //查询评论列表
    @Test
    void queryCommentList() {
        DyResult<CommentListVo> dyResult = DyWebClient.getInstance().queryCommentList(openId, itemId, "time", 100, 0);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //查询评论回复列表
    @Test
    void queryCommentReplyList() {
        DyResult<CommentListVo> dyResult = DyWebClient.getInstance().queryCommentReplyList(openId, itemId, commentId,"time", 100, 0);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //发表评论回复
    @Test
    void commentReply() {
        DyResult<CommentReplyVo> dyResult = DyWebClient.getInstance().commentReply(CommentQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }
}