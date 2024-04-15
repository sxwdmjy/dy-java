package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;

import java.util.Objects;

/**
 * 图片
 * @author danmo
 * @date 2024-04-08 14:23
 **/
public class ImageMsg extends MsgContent{


    private JSONObject image;

    public ImageMsg() {
        super.setMsg_type(MediaTypeEnum.IMAGE);
    }


    public JSONObject getImage() {
        return image;
    }

    public void setImage(String mediaId) {
        if (Objects.isNull(this.image)) {
            this.image = new JSONObject();
        }
        this.image.put("media_id", mediaId);
    }

    public void setImage(JSONObject image) {
        this.image = image;
    }

    public static ImageMsgBuilder builder() {
        return new ImageMsgBuilder();
    }

    public static class ImageMsgBuilder {
        private String mediaId;
        public ImageMsgBuilder mediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }
        public ImageMsg build() {
            ImageMsg imageMsg = new ImageMsg();
            imageMsg.setImage(mediaId);
            return imageMsg;
        }
    }
}
