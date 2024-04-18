package com.dyj.common.domain;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.enums.MediaTypeEnum;
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
        super.setMsg_type(MediaTypeEnum.APPLET_COUPON);
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

    public static AppletCouponMsgBuilder builder() {
        return new AppletCouponMsgBuilder();
    }
    public static class AppletCouponMsgBuilder {
        private String activityId;
        private String couponMetaId;
        public AppletCouponMsgBuilder activityId(String activityId) {
            this.activityId = activityId;
            return this;
        }
        public AppletCouponMsgBuilder couponMetaId(String couponMetaId) {
            this.couponMetaId = couponMetaId;
            return this;
        }
        public AppletCouponMsg build() {
            AppletCouponMsg appletCouponMsg = new AppletCouponMsg();
            appletCouponMsg.setAppletCoupon(activityId,couponMetaId);
            return appletCouponMsg;
        }
    }

}
