package com.dyj.web.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.FansGroup;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 10:29
 **/
public class FansGroupVo extends DyResult<BaseVo> {

    private List<FansGroup> group_list;

    public List<FansGroup> getGroup_list() {
        return group_list;
    }

    public void setGroup_list(List<FansGroup> group_list) {
        this.group_list = group_list;
    }
}
