package com.dyj.applet.domain.query;

import com.dyj.applet.domain.ColorRGB;
import com.dyj.common.domain.query.BaseQuery;

/**
 * @author danmo
 * @date 2024-04-17 14:20
 **/
public class CreateQrCodeQuery extends BaseQuery {

    private String app_id;

    private String app_name;

    private String path;

    private Integer width;

    private Boolean set_icon;

    private ColorRGB line_color;
    private ColorRGB background;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getSet_icon() {
        return set_icon;
    }

    public void setSet_icon(Boolean set_icon) {
        this.set_icon = set_icon;
    }

    public ColorRGB getLine_color() {
        return line_color;
    }

    public void setLine_color(ColorRGB line_color) {
        this.line_color = line_color;
    }

    public ColorRGB getBackground() {
        return background;
    }

    public void setBackground(ColorRGB background) {
        this.background = background;
    }

    public static CreateQrCodeQueryBuilder builder() {
        return new CreateQrCodeQueryBuilder();
    }

    public static class CreateQrCodeQueryBuilder {
        private String appId;
        private String appName;
        private String path;
        private Integer width;
        private Boolean setIcon;
        private ColorRGB lineColor;
        private ColorRGB background;

        private Integer tenantId;
        private String clientKey;

        public CreateQrCodeQueryBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public CreateQrCodeQueryBuilder appName(String appName) {
            this.appName = appName;
            return this;
        }

        public CreateQrCodeQueryBuilder path(String path) {
            this.path = path;
            return this;
        }

        public CreateQrCodeQueryBuilder width(Integer width) {
            this.width = width;
            return this;
        }

        public CreateQrCodeQueryBuilder setIcon(Boolean setIcon) {
            this.setIcon = setIcon;
            return this;
        }

        public CreateQrCodeQueryBuilder lineColor(ColorRGB lineColor) {
            this.lineColor = lineColor;
            return this;
        }

        public CreateQrCodeQueryBuilder background(ColorRGB background) {
            this.background = background;
            return this;
        }

        public CreateQrCodeQueryBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public CreateQrCodeQueryBuilder clientKey(String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public CreateQrCodeQuery build() {
            CreateQrCodeQuery createQrCodeQuery = new CreateQrCodeQuery();
            createQrCodeQuery.setApp_id(appId);
            createQrCodeQuery.setApp_name(appName);
            createQrCodeQuery.setPath(path);
            createQrCodeQuery.setWidth(width);
            createQrCodeQuery.setSet_icon(setIcon);
            createQrCodeQuery.setLine_color(lineColor);
            createQrCodeQuery.setBackground(background);
            createQrCodeQuery.setTenantId(tenantId);
            createQrCodeQuery.setClientKey(clientKey);
            return createQrCodeQuery;
        }
    }
}
