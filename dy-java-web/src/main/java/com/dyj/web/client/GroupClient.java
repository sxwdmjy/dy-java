package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.common.domain.vo.BaseVo;
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

    @Post(value = "${createFansGroup}", interceptor = TokenHeaderInterceptor.class)
    CreateFansGroupVo createFansGroup(@JSONBody CreateFansGroupQuery query);

    @Post(value = "${setFansGroupEnterStatus}", interceptor = TokenHeaderInterceptor.class)
    SetFansGroupEnterStatusVo setFansGroupEnterStatus(@JSONBody SetFansGroupEnterStatusQuery query);

    @Get(value = "${queryFansGroup}", interceptor = TokenHeaderInterceptor.class)
    FansGroupVo queryFansGroup(@Var("query") UserInfoQuery query);

    @Post(value = "${queryFansGroupSetting}", interceptor = TokenHeaderInterceptor.class)
    FansGroupSettingVo queryFansGroupSetting(@JSONBody FansGroupSettingQuery query);

    @Post(value = "${cancelFansGroupSetting}", interceptor = TokenHeaderInterceptor.class)
    FansGroupSettingVo cancelFansGroupSetting(@JSONBody FansGroupSettingQuery query);

    @Get(value = "${queryFansGroupCount}", interceptor = TokenHeaderInterceptor.class)
    FansGroupCountVo queryFansGroupCount(@Var("query") UserInfoQuery query);

    @Get(value = "${queryFansGroupEnterStatus}", interceptor = TokenHeaderInterceptor.class)
    FansGroupEnterStatusVo queryFansGroupEnterStatus(@Var("query") UserInfoQuery query, @Query("count") Integer count, @Query("cursor") Integer cursor);

    @Post(value = "${sendGroupMessage}", interceptor = TokenHeaderInterceptor.class)
    ChatMsgResponseVo sendGroupMessage(@JSONBody SendGroupMsgQuery query);

    @Post(value = "${revokeGroupMessage}", interceptor = TokenHeaderInterceptor.class)
    DySimpleResult<BaseVo> revokeGroupMessage(@JSONBody RevokeGroupMsgQuery query);
}
