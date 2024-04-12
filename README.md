![输入图片说明](Logo.png)

#### 介绍
抖音Java开发工具包，支持包括移动\网站应用、开放平台、抖店、小程序等抖音开发功能模块的后端开发

 **简化接口调用方式，开箱即用** 

#### Maven 引用方式

```xml
 <dependency>
     <groupId>com.dyj</groupId>
     <artifactId>（不同模块参考下文）</artifactId>
     <version>${dy-java.version}</version>
 </dependency>
```
- 移动\网站应用：`dy-java-web`   

#### 文件配置
``` yml
dyjava:
  beanId:  
  agents:  #可配置多个应用
    - tenantId: 1   #租户名称
      clientKey:  #应用Key
      clientSecret:   #应用秘钥
  #应用信息加载类，默认读取配置文件 实现IAgentConfigService接口
  agentSourceClass: com.dyj.common.service.impl.PropertiesAgentConfigServiceImpl
  #令牌信息加载类，默认读取缓存 实现IAgentTokenService接口
  tokenSourceClass: com.dyj.common.service.impl.CacheAgentTokenServiceImpl
  forest:
    backend: okhttp3             # 后端HTTP框架httpclient、okhttp3（默认为 okhttp3）
    max-connections: 1000        # 连接池最大连接数（默认为 500）
    max-route-connections: 500   # 每个路由的最大连接数（默认为 500）
    max-request-queue-size: 500  # 最大请求等待队列大小
    max-async-thread-size: 300   # 最大异步线程数
    max-async-queue-size: 16     # 最大异步线程池队列大小
    timeout: 3000                # 请求超时时间，单位为毫秒（默认为 3000）
    connect-timeout: 3000        # 连接超时时间，单位为毫秒（默认为 timeout）
    read-timeout: 3000           # 数据读取超时时间，单位为毫秒（默认为 timeout）
    max-retry-count: 3           # 请求失败后重试次数（默认为 0 次不重试）
    ssl-protocol: TLS            # 单向验证的HTTPS的默认TLS协议（默认为 TLS）
    log-enabled: true            # 打开或关闭日志（默认为 true）
    log-request: true            # 打开/关闭请求日志（默认为 true）
    log-response-status: true    # 打开/关闭响应状态日志（默认为 true）
    log-response-content: false  # 打开/关闭响应内容日志（默认为 false）
    async-mode: platform         # 异步模式（默认为 platform）
```

#### 使用示例

* 移动\网站应用：
```java
//单租户获取AccessToken
AccessTokenVo accessToken = DyWebClient.getInstance().accessToken(code).getData();
//多租户单应用获取AccessToken
AccessTokenVo accessToken = DyWebClient.getInstance()
        .tenantId(1)
        .accessToken(code).getData();
//多租户多应用获取AccessToken
AccessTokenVo accessToken = DyWebClient.getInstance()
        .tenantId(1)
        .clientKey("123")
        .accessToken(code).getData();
```

#### 开发规划
###### 接口接入计划
1. 网站应用、App(2024-04-15前完成)
2. 小程序(2024-04-30前完成)
3. 直播(2024-05-15前完成)
4. 抖店(2024-05-30前完成)

###### 感谢
[forest是一个很好用的工具](https://forest.dtflyx.com/) 

###### 贡献
如果您发现了任何问题或者有任何建议，欢迎提出 issue 或者提交 pull request。也可以联系下方二维码。

![输入图片说明](image2.png)