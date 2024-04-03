package com.dyj.spring.config;

import com.dtflys.forest.springboot.ForestAutoConfiguration;
import com.dtflys.forest.springboot.annotation.ForestScan;
import com.dyj.spring.DyConfigurationRegister;
import com.dyj.spring.properties.DyConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * @author danmo
 * @date 2024-04-02 13:44
 **/
@Configuration
@EnableConfigurationProperties({DyConfigurationProperties.class})
@AutoConfigureAfter(ForestAutoConfiguration.class)
public class DyAutoConfiguration {


    @Resource
    private ConfigurableApplicationContext applicationContext;


    @Bean
    @ConditionalOnMissingBean
    public DyConfigurationRegister beanRegister(DyConfigurationProperties properties) {
        DyConfigurationRegister register = new DyConfigurationRegister(
                applicationContext,
                properties);
        register.registerDyConfiguration();
        register.setForestProperties();
        return register;
    }
}
