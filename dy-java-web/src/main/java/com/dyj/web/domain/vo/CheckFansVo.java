package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-07 16:48
 **/
public class CheckFansVo extends BaseVo{

    /**
     * follower_open_id是否关注了open_id
     */
    private Boolean is_follower;

    /**
     * 若关注了，则返回关注时间。单位为秒级时间戳
     */
    private Long follow_time;

    public Boolean getIs_follower() {
        return is_follower;
    }

    public void setIs_follower(Boolean is_follower) {
        this.is_follower = is_follower;
    }

    public Long getFollow_time() {
        return follow_time;
    }

    public void setFollow_time(Long follow_time) {
        this.follow_time = follow_time;
    }

    @Override
    public String toString() {
        return "CheckFansVo{" +
                "is_follower=" + is_follower +
                ", follow_time=" + follow_time +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
