package com.dyj.spring;

import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.utils.StringUtils;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.enums.DyConfigEnum;
import com.dyj.spring.properties.DyConfigurationProperties;
import com.dyj.spring.properties.DyForestConfigurationProperties;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import java.util.Objects;

/**
 * @author danmo
 * @date 2024-04-02 13:52
 **/
public class DyConfigurationRegister implements ResourceLoaderAware, BeanPostProcessor {

    private final ConfigurableApplicationContext applicationContext;
    private DyConfigurationProperties dyConfigurationProperties;

    private ResourceLoader resourceLoader;

    public DyConfigurationRegister(ConfigurableApplicationContext applicationContext, DyConfigurationProperties dyConfigurationProperties) {
        this.applicationContext = applicationContext;
        this.dyConfigurationProperties = dyConfigurationProperties;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void registerDyConfiguration() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DyConfiguration.class);
        String id = dyConfigurationProperties.getBeanId();
        if (StringUtils.isBlank(id)) {
            id = "dyConfiguration";
        }
        beanDefinitionBuilder
                .addPropertyValue("agents", dyConfigurationProperties.getAgents())
                .setLazyInit(false)
                .setFactoryMethod("configuration")
                .addConstructorArgValue(id);


        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
        beanFactory.registerBeanDefinition(id, beanDefinition);

        DyConfiguration configuration = applicationContext.getBean(id, DyConfiguration.class);
        //configuration.setInterceptorFactory(DyInterceptorFactory);

    }

    public void setForestProperties() {
        DyForestConfigurationProperties forestProperties = dyConfigurationProperties.getForest();
        if (Objects.nonNull(forestProperties)) {
            ForestConfiguration forestConfiguration = applicationContext.getBean(ForestConfiguration.class);
            forestConfiguration.setBackendName(forestProperties.getBackend());
            forestConfiguration.setMaxConnections(forestProperties.getMaxConnections());
            forestConfiguration.setMaxRouteConnections(forestProperties.getMaxRouteConnections());
            forestConfiguration.setMaxRequestQueueSize(forestProperties.getMaxRequestQueueSize());
            forestConfiguration.setMaxAsyncThreadSize(forestProperties.getMaxAsyncThreadSize());
            forestConfiguration.setMaxAsyncQueueSize(forestProperties.getMaxAsyncQueueSize());
            forestConfiguration.setConnectTimeout(forestProperties.getConnectTimeout());
            forestConfiguration.setTimeout(forestProperties.getTimeout());
            forestConfiguration.setReadTimeout(forestProperties.getReadTimeout());
            forestConfiguration.setMaxRetryCount(forestProperties.getMaxRetryCount());
            forestConfiguration.setLogEnabled(forestProperties.isLogEnabled());
            forestConfiguration.setLogRequest(forestProperties.isLogRequest());
            forestConfiguration.setLogResponseStatus(forestProperties.isLogResponseStatus());
            forestConfiguration.setLogResponseContent(forestProperties.isLogResponseContent());
            forestConfiguration.setAsyncMode(forestProperties.getAsyncMode());
            for (DyConfigEnum value : DyConfigEnum.values()) {
                forestProperties.getVariables().put(value.getKey(), value.getValue());
            }
            forestConfiguration.setVariables(forestProperties.getVariables());
        }
    }


}
