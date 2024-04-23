package com.dyj.applet.domain.vo;

/**
 * @author danmo
 * @date 2024-04-23 14:13
 **/
public class CreateTaskVo {

    /**
     *
     */
    private String task_id;

    /**
     * 任务状态 1-进行中，2-未开始，3-已过期
     */
    private Integer task_status;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public Integer getTask_status() {
        return task_status;
    }

    public void setTask_status(Integer task_status) {
        this.task_status = task_status;
    }
}
