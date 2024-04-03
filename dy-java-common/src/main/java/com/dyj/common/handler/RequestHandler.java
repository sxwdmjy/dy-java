package com.dyj.common.handler;

import com.dyj.common.config.DyConfiguration;

/**
 * @author danmo
 * @date 2024-04-03 16:51
 **/
public class RequestHandler {

    private DyConfiguration dyConfiguration;

    public RequestHandler() {

    }

    private static volatile RequestHandler handler = null;


    public static RequestHandler getInstance() {
        if (handler == null) {
            synchronized (RequestHandler.class) {
                if (handler == null) {
                    handler = new RequestHandler();
                }
            }
        }
        return handler;
    }

    public DyConfiguration getDyConfiguration() {
        return dyConfiguration;
    }

    public void setDyConfiguration(DyConfiguration dyConfiguration) {
        this.dyConfiguration = dyConfiguration;
    }
}
