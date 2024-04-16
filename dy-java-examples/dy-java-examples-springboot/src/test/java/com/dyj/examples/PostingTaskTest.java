package com.dyj.examples;


import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.query.ConfirmPostingTaskQuery;
import com.dyj.web.domain.query.CreatePostingTaskQuery;
import com.dyj.web.domain.query.PostingTaskQuery;
import com.dyj.web.domain.query.VideoDataQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.ConfirmPostingTaskVo;
import com.dyj.web.domain.vo.PostingTaskVo;
import com.dyj.web.domain.vo.VideoBasicListVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
class PostingTaskTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    private final String itemId = "";

    //创建投稿任务
    @Test
    void createPostingTask() {
        DyResult<PostingTaskVo> postingTask = DyWebClient.getInstance().createPostingTask(CreatePostingTaskQuery.builder()
                .taskName("")
                .build());
        System.out.println(JSONObject.toJSONString(postingTask));
    }

    //绑定视频
    @Test
    void postingTaskBindVideo() {
        DyResult<BaseVo> dyResult = DyWebClient.getInstance().postingTaskBindVideo(PostingTaskQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //核销投稿任务
    @Test
    void confirmPostingTask() {
        DyResult<ConfirmPostingTaskVo> dyResult = DyWebClient.getInstance().confirmPostingTask(ConfirmPostingTaskQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    //查询视频基础信息
    @Test
    void queryVideoBasicInfo() {
        DyResult<VideoBasicListVo> dyResult = DyWebClient.getInstance().queryVideoBasicInfo(VideoDataQuery.builder().build());
        System.out.println(JSONObject.toJSONString(dyResult));
    }
}