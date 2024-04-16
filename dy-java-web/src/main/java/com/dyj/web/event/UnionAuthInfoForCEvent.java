package com.dyj.web.event;

/**
 * union_auth_info_for_c 事件
 * unionauth.identification
 * 联合授权openid信息webhook推送
 */
public class UnionAuthInfoForCEvent {

    /**
     * 绑定的b端应用id
     */
    private String b_client_key;
    /**
     *  绑定的b端应用id对应的openid
     */
    private String b_open_id;
    /**
     * c端应用的id。
     */
    private String c_client_key;
    /**
     * c端应用对应的openid，即用户在当前小程序对应的openid。
     */
    private String c_open_id;

    public String getB_client_key() {
        return b_client_key;
    }

    public void setB_client_key(String b_client_key) {
        this.b_client_key = b_client_key;
    }

    public String getB_open_id() {
        return b_open_id;
    }

    public void setB_open_id(String b_open_id) {
        this.b_open_id = b_open_id;
    }

    public String getC_client_key() {
        return c_client_key;
    }

    public void setC_client_key(String c_client_key) {
        this.c_client_key = c_client_key;
    }

    public String getC_open_id() {
        return c_open_id;
    }

    public void setC_open_id(String c_open_id) {
        this.c_open_id = c_open_id;
    }
}
