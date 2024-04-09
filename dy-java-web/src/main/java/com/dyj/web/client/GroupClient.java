package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.web.domain.query.*;
import com.dyj.web.domain.vo.*;
import com.dyj.web.interceptor.TokenHeaderInterceptor;

/**
 * 群组管理
 * @author danmo
 * @date 2024/04/09 14:08
 */
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface GroupClient {

    @Post(value = "${createFansGroup}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    CreateFansGroupVo createFansGroup(@JSONBody @Var("query") CreateFansGroupQuery query);

    @Post(value = "${setFansGroupEnterStatus}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    SetFansGroupEnterStatusVo setFansGroupEnterStatus(@JSONBody @Var("query") SetFansGroupEnterStatusQuery query);

    @Get(value = "${queryFansGroup}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    FansGroupVo queryFansGroup(@Var("query") UserInfoQuery query);

    @Post(value = "${queryFansGroupSetting}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    FansGroupSettingVo queryFansGroupSetting(@JSONBody @Var("query") FansGroupSettingQuery query);

    @Post(value = "${cancelFansGroupSetting}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    FansGroupSettingVo cancelFansGroupSetting(@JSONBody @Var("query") FansGroupSettingQuery query);

    @Get(value = "${queryFansGroupCount}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    FansGroupCountVo queryFansGroupCount(@Var("query") UserInfoQuery query);

    @Get(value = "${queryFansGroupEnterStatus}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    FansGroupEnterStatusVo queryFansGroupEnterStatus(@Var("query") UserInfoQuery query, @Query("count") Integer count, @Query("cursor") Integer cursor);

    @Post(value = "${sendGroupMessage}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    ChatMsgResponseVo sendGroupMessage(@JSONBody @Var("query") SendGroupMsgQuery query);

    @Post(value = "${revokeGroupMessage}?open_id=${query.open_id}", interceptor = TokenHeaderInterceptor.class)
    DySimpleResult revokeGroupMessage(@JSONBody @Var("query") RevokeGroupMsgQuery query);
}
