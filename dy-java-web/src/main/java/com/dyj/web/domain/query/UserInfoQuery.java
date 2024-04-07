package com.dyj.web.domain.query;

/**
 * @author danmo
 * @date 2024-04-07 14:56
 **/
public class UserInfoQuery extends BaseQuery{

    /**
     * 用户唯一标志
     */
    protected String open_id;



    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }


}
