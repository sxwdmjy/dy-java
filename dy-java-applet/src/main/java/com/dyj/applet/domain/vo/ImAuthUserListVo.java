package com.dyj.applet.domain.vo;

import com.dyj.applet.domain.ImAuthUser;
import com.dyj.common.domain.vo.BaseVo;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-08 17:18
 **/
public class ImAuthUserListVo extends BaseVo {

    private List<ImAuthUser> auth_user_list;


    private Boolean has_more;
}
