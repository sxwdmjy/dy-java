package com.dyj.web.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-09 10:27
 **/
public class SetFansGroupEnterStatusVo extends DyResult<BaseVo> {

    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


}
