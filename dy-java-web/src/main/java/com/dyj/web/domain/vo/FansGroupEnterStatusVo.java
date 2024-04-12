package com.dyj.web.domain.vo;

import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-09 11:19
 **/
public class FansGroupEnterStatusVo extends DyResult<BaseVo> {

    private FansGroupEnterStatusApplyVo apply_list;

    public FansGroupEnterStatusApplyVo getApply_list() {
        return apply_list;
    }

    public void setApply_list(FansGroupEnterStatusApplyVo apply_list) {
        this.apply_list = apply_list;
    }
}
