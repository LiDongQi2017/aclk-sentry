package com.sentry.io.config;

import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class SentryConfigurer {

    /**
     * 当前环境的配置文件
     */
    @Value("${spring.profiles.active:default}")
    private String environment;

    /**
     * 当前环境的 客户端密钥
     */
    @Value("${sentry.dsn:}")
    private String dsn;

    @PostConstruct
    public void setUp() {
        if (StringUtils.isBlank(dsn)) {
            log.warn("Starting without Sentry, because there is no dsn for Sentry in configuration.");
        } else {
            log.info("Sentry environment=[{}]", environment);
            Sentry.init(dsn + "?environment=" + environment);
        }
    }
}
