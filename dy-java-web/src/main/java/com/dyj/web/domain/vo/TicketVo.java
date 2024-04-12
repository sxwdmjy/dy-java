package com.dyj.web.domain.vo;

/**
 * @author danmo
 * @date 2024-04-11 18:53
 **/
public class TicketVo extends BaseVo{

    /**
     * 凭证超时时间，单位（秒)
     */
    private Long expires_in;

    /**
     * 凭证
     */
    private String ticket;

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }


}
