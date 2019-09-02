package com.raindew.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author raindew
 * @Date 2019/9/2
 * Spring Session 提供了一套创建和管理 Servlet HttpSession 的方案。
 * Spring Session 提供了集群 Session（Clustered Sessions）功能，默认采用外置的 Redis 来存储 Session 数据，以此来解决 Session 共享的问题
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30) // 设置session失效时间
public class SessionConfig {
}
