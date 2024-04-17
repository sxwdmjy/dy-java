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
}
