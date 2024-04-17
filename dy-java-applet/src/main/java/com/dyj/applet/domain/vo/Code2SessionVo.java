package com.dyj.applet.domain.vo;

/**
 * @author danmo
 * @date 2024-04-17 10:57
 **/
public class Code2SessionVo {

    /**
     * 会话密钥，如果请求时有 code 参数才会返回Tip：session_key 会随着login接口的调用被刷新。
     * 可以通过checkSession方法验证当前 session 是否有效，从而避免频繁登录。
     * Tip：session_key 会话密钥 session_key 是对用户数据进行 加密签名 的密钥。
     * 为了应用自身的数据安全，开发者服务器不应该把会话密钥下发到小程序，也不应该对外提供这个密钥。
     */
    private String session_key;

    /**
     * 用户在当前小程序的 ID，如果请求时有 code 参数才会返回
     */
    private String openid;
    /**
     * 用户在小程序平台的唯一标识符，请求时有 code 参数才会返回。如果开发者拥有多个小程序，可通过 unionid 来区分用户的唯一性。
     * Tip：对于同一个用户，不同的宿主或不同的开发者得到的 unionid 是不同的。
     */
    private String unionid;

    /**
     * 匿名用户在当前小程序的 ID，如果请求时有 anonymous_code 参数才会返回
     */
    private String anonymous_openid;


    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getAnonymous_openid() {
        return anonymous_openid;
    }

    public void setAnonymous_openid(String anonymous_openid) {
        this.anonymous_openid = anonymous_openid;
    }
}
