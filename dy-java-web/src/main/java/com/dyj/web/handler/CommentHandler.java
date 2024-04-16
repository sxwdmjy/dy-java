package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.CommentQuery;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.CommentListVo;
import com.dyj.web.domain.vo.CommentReplyVo;

/**
 * @author danmo
 * @date 2024-04-10 17:11
 **/
public class CommentHandler extends AbstractWebHandler {

    public CommentHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    public DyResult<BaseVo> commentTop(CommentQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getCommentClient().commentTop(query);
    }

    public DyResult<CommentListVo> queryCommentList(String openId, String itemId, String sortType, Integer count, Integer cursor) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getCommentClient().queryCommentList(query, itemId, sortType, count, cursor);
    }

    public DyResult<CommentListVo> queryCommentReplyList(String openId, String itemId, String commentId, String sortType, Integer count, Integer cursor) {
        UserInfoQuery query = new UserInfoQuery();
        query.setOpen_id(openId);
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getCommentClient().queryCommentReplyList(query, itemId,commentId, sortType, count, cursor);
    }

    public DyResult<CommentReplyVo> commentReply(CommentQuery query) {
        query.setTenantId(agentConfiguration.getTenantId());
        query.setClientKey(agentConfiguration.getClientKey());
        return getCommentClient().commentReply(query);
    }
}
