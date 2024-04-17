package com.dyj.applet.handler;

import com.dyj.applet.domain.query.Code2SessionQuery;
import com.dyj.applet.domain.vo.Code2SessionVo;
import com.dyj.common.config.AgentConfiguration;
import com.dyj.common.domain.DySimpleResult;

/**
 * @author danmo
 * @date 2024-04-03 13:59
 **/
public class LoginHandler extends AbstractAppletHandler {

    public LoginHandler(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
    }

    /**
     * code2Session
     * @param code login 接口返回的登录凭证
     * @param anonymousCode login 接口返回的匿名登录凭证
     * @return  DySimpleResult<Code2SessionVo>
     */
    public DySimpleResult<Code2SessionVo> code2Session(String code, String anonymousCode) {
        return getLoginClient().code2Session(Code2SessionQuery.builder()
                .appid(agentConfiguration.getClientKey())
                .secret(agentConfiguration.getClientSecret())
                .code(code)
                .anonymousCode(anonymousCode).build());
    }
}
