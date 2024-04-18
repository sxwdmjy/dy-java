package com.dyj.applet.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dyj.applet.domain.query.ImAuthStatusQuery;
import com.dyj.applet.domain.query.ImAuthorizeUserListQuery;
import com.dyj.applet.domain.query.RevokeMsgQuery;
import com.dyj.applet.domain.query.SendMsgQuery;
import com.dyj.applet.domain.vo.AuthSendMsgVo;
import com.dyj.applet.domain.vo.ImAuthStatusVo;
import com.dyj.applet.domain.vo.ImAuthUserListVo;
import com.dyj.applet.domain.vo.SendMsgResponseVo;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.common.interceptor.BizTokenHeaderInterceptor;

/**
 * 私信管理
 *
 * @author danmo
 * @date 2024-04-08 09:36
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON, interceptor = BizTokenHeaderInterceptor.class)
public interface ChatMsgClient {

    /**
     * 发送私信消息
     *
     * @param query 入参
     * @return ChatMsgResponseVo
     */
    @Post(url = "${sendMessage}")
    SendMsgResponseVo sendMessage(@JSONBody SendMsgQuery query);

    /**
     * 发送主动私信
     * @param query 入参
     * @return DySimpleResult<AuthSendMsgVo>
     */
    @Post(url = "${authSendMsg}")
    DySimpleResult<AuthSendMsgVo> authSendMsg(@JSONBody SendMsgQuery query);


    /**
     * 查询主动私信用户授权状态
     * @param query 入参
     * @return DySimpleResult<ImAuthStatusVo>
     */
    @Post(url = "${imAuthStatus}")
    DySimpleResult<ImAuthStatusVo> queryImAuthStatus(@JSONBody ImAuthStatusQuery query);

    /**
     * 查询授权主动私信用户
     *
     * @param query
     * @return DyResult<AuthorizeUserListVo>
     */
    @Post(url = "${queryAuthorizeUserList}")
    DySimpleResult<ImAuthUserListVo> queryAuthorizeUserList(@JSONBody ImAuthorizeUserListQuery query);

    /**
     * 私信消息撤回
     *
     * @param query 包含消息查询条件的对象，用于指定要撤销的消息。
     * @return 返回一个动态结果对象，其中包含操作的结果信息。
     */
    @Post(url = "${revokeMessage}")
    DyResult<BaseVo> revokeMessage(@JSONBody RevokeMsgQuery query);
}
