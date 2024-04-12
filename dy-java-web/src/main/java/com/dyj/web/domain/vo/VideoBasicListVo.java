package com.dyj.web.domain.vo;

import com.dyj.web.domain.VideoBasicInfo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-11 14:11
 **/
public class VideoBasicListVo extends BaseVo {

    private List<VideoBasicInfo> list;

    public List<VideoBasicInfo> getList() {
        return list;
    }

    public void setList(List<VideoBasicInfo> list) {
        this.list = list;
    }


}
