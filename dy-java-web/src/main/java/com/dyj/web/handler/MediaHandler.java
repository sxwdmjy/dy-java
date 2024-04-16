package com.dyj.web.handler;

import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.UserInfoQuery;
import com.dyj.common.domain.vo.BaseVo;
import com.dyj.web.domain.vo.MaterialListVo;
import com.dyj.web.domain.vo.UploadMaterialVo;

/**
 * @author danmo
 * @date 2024-04-11 15:23
 **/
public class MediaHandler extends AbstractWebHandler {

    public MediaHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * 上传素材
     *
     * @param bytes bytes
     * @return DyResult<UploadMaterialVo>
     */
    public DyResult<UploadMaterialVo> uploadMaterial(byte[] bytes) {
        return getMediaClient().uploadMaterial(userInfoQuery(), bytes);
    }

    /**
     * 上传临时素材
     *
     * @param bytes bytes
     * @return DyResult<UploadMaterialVo>
     */
    public DyResult<UploadMaterialVo> uploadTemporaryMaterial(byte[] bytes) {
        return getMediaClient().uploadTemporaryMaterial(userInfoQuery(), bytes);
    }

    /**
     * 素材列表接口
     *
     * @param openId 用户ID
     * @param cursor cursor
     * @param count  数量
     * @return DyResult<MaterialListVo>
     */
    public DyResult<MaterialListVo> queryMaterialList(String openId, Integer cursor, Integer count) {
        UserInfoQuery query = userInfoQuery();
        query.setOpen_id(openId);
        return getMediaClient().queryMaterialList(query, cursor, count);
    }

    /**
     * 删除素材
     * @param openId 用户ID
     * @param mediaId 素材ID
     * @return DyResult<BaseVo>
     */
    public DyResult<BaseVo> deleteMaterial(String openId, String mediaId) {
        return getMediaClient().deleteMaterial(userInfoQuery(openId), mediaId);
    }
}
