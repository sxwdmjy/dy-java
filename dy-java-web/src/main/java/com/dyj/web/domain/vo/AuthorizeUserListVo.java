package com.dyj.web.domain.vo;

import com.dyj.web.domain.AuthUser;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-08 17:18
 **/
public class AuthorizeUserListVo extends BaseVo{

    private List<AuthUser> auth_user_list;


    private Boolean has_more;
}
