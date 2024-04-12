package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;

import java.util.Objects;

/**
 * 视频
 * @author danmo
 * @date 2024-04-08 14:23
 **/
public class VideoMsg extends MsgContent {


    private JSONObject video;

    public VideoMsg() {
        super.setMsg_type(MediaTypeEnum.VIDEO);
    }

    public JSONObject getVideo() {
        return video;
    }

    public void setVideo(String itemId) {
        if (Objects.isNull(this.video)) {
            this.video = new JSONObject();
        }
        this.video.put("item_id", itemId);
    }

    public void setVideo(JSONObject video) {
        this.video = video;
    }

    public static VideoMsg build() {
        return new VideoMsg();
    }

    public VideoMsg itemId(String itemId) {
        setVideo(itemId);
        return this;
    }
}
