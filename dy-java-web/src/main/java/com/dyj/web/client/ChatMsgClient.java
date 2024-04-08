package com.dyj.web.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.AuthorizeUserListQuery;
import com.dyj.web.domain.query.RevokeMsgQuery;
import com.dyj.web.domain.query.SendMsgQuery;
import com.dyj.web.domain.vo.AuthorizeUserListVo;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * @author danmo
 * @date 2024-04-08 09:36
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON, interceptor = TokenHeaderInterceptor.class)
public interface ChatMsgClient {

    /**
     * 发送私信消息
     *
     * @param query
     * @return DyResult<BaseVo>
     */
    @Post(url = "${sendMessage}?open_id=${query.open_id}")
    DyResult<BaseVo> sendMessage(@JSONBody @Var("query") SendMsgQuery query);

    /**
     * 查询授权主动私信用户
     *
     * @param query
     * @return DyResult<AuthorizeUserListVo>
     */
    @Post(url = "${queryAuthorizeUserList}?open_id=${query.open_id}")
    DyResult<AuthorizeUserListVo> queryAuthorizeUserList(@JSONBody @Var("query") AuthorizeUserListQuery query);


    /**
     * 私信消息撤回
     *
     * @param query 包含消息查询条件的对象，用于指定要撤销的消息。
     * @return 返回一个动态结果对象，其中包含操作的结果信息。
     */
    @Post(url = "${revokeMessage}?open_id=${query.open_id}")
    DyResult<BaseVo> revokeMessage(@JSONBody @Var("query") RevokeMsgQuery query);
}
