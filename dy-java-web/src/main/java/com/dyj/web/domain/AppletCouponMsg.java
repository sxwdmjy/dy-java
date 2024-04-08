package com.dyj.web.domain;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 小程序券
 * @author danmo
 * @date 2024-04-08 16:47
 **/
public class AppletCouponMsg extends MsgContent{

    private JSONObject applet_coupon;

    public AppletCouponMsg() {
        super.msg_type = 11;
    }

    public JSONObject getApplet_coupon() {
        return applet_coupon;
    }

    public void setApplet_coupon(JSONObject applet_coupon) {
        this.applet_coupon = applet_coupon;
    }

    public void setAppletCoupon(String activityId ,String couponMetaId) {
        if (Objects.isNull(this.applet_coupon)) {
            this.applet_coupon = new JSONObject();
        }

        if (StringUtils.hasLength(activityId)){
            this.applet_coupon.put("activity_id",activityId);
        }
        if (StringUtils.hasLength(couponMetaId)){
            this.applet_coupon.put("coupon_meta_id",couponMetaId);
        }
    }

    public static AppletCouponMsg build() {
        return new AppletCouponMsg();
    }

    public AppletCouponMsg activityId(String activityId) {
        setAppletCoupon(activityId,null);
        return this;
    }

    public AppletCouponMsg couponMetaId(String couponMetaId) {
        setAppletCoupon(null,couponMetaId);
        return this;
    }
}
