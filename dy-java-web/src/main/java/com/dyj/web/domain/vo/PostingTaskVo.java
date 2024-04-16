package com.dyj.web.domain.vo;

import com.dyj.common.domain.vo.BaseVo;

/**
 * @author danmo
 * @date 2024-04-11 13:57
 **/
public class PostingTaskVo extends BaseVo {

    /**
     * 任务id
     */
    private String task_id;

    /**
     * 任务状态 1-进行中，2-未开始，3-已过期
     */
    private String task_status;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }


}
