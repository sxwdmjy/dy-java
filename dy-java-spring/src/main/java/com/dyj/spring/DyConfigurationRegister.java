package com.dyj.spring;

import com.dtflys.forest.config.ForestConfiguration;
import com.dyj.common.config.DyConfiguration;
import com.dyj.common.enums.DyUrlPathEnum;
import com.dyj.common.handler.RequestHandler;
import com.dyj.common.service.IAgentConfigService;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.spring.properties.DyConfigurationProperties;
import com.dyj.spring.properties.DyForestConfigurationProperties;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author danmo
 * @date 2024-04-02 13:52
 **/
public class DyConfigurationRegister implements ResourceLoaderAware, BeanPostProcessor {

    private final ConfigurableApplicationContext applicationContext;
    private final DyConfigurationProperties dyConfigurationProperties;

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
        if (!StringUtils.hasLength(id)) {
            id = "dyConfiguration";
        }
        beanDefinitionBuilder
                .addPropertyValue("agents", dyConfigurationProperties.getAgents())
                .addPropertyValue("defaultId", dyConfigurationProperties.getDefaultId())
                .setLazyInit(false)
                .setFactoryMethod("configuration")
                .addConstructorArgValue(id);


        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
        beanFactory.registerBeanDefinition(id, beanDefinition);

        DyConfiguration configuration = applicationContext.getBean(id, DyConfiguration.class);
        String agentSourceClass = dyConfigurationProperties.getAgentSourceClass();
        //根据类详细路径获取类对象
        if (StringUtils.hasLength(agentSourceClass)) {
            IAgentConfigService bean = applicationContext.getBean("dyAgentSource", IAgentConfigService.class);
            configuration.setAgentConfigService(bean);
        }
        String tokenSourceClass = dyConfigurationProperties.getTokenSourceClass();
        if (StringUtils.hasLength(tokenSourceClass)) {
            IAgentTokenService agentTokenService =  applicationContext.getBean("dyTokenService", IAgentTokenService.class);
            configuration.setAgentTokenService(agentTokenService);
        }
        //configuration.setInterceptorFactory(DyInterceptorFactory);
        RequestHandler.getInstance().setDyConfiguration(configuration);
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
            for (DyUrlPathEnum value : DyUrlPathEnum.values()) {
                forestProperties.getVariables().put(value.getKey(), value.getValue());
            }
            forestConfiguration.setVariables(forestProperties.getVariables());
        }
    }


    public void registerAgentSource() {
        String agentSourceClass = dyConfigurationProperties.getAgentSourceClass();
        //根据类详细路径获取类对象
        if (StringUtils.hasLength(agentSourceClass)) {
            try {
                Class<?> aClass = Class.forName(agentSourceClass);
                if (!IAgentConfigService.class.isAssignableFrom(aClass)) {
                    throw new RuntimeException("property 'agentConfig' must be a class extending from com.dyj.common.service.IAgentConfigService");
                }
                BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
                beanFactory.registerBeanDefinition("dyAgentSource", BeanDefinitionBuilder.genericBeanDefinition(aClass).getRawBeanDefinition());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void registerTokenSource() {
        String tokenSourceClass = dyConfigurationProperties.getTokenSourceClass();
        if (StringUtils.hasLength(tokenSourceClass)) {
            try {
                Class<?> aClass = Class.forName(tokenSourceClass);
                if (!IAgentTokenService.class.isAssignableFrom(aClass)) {
                    throw new RuntimeException("property 'agentToken' must be a class extending from com.dyj.common.service.IAgentTokenService");
                }
                BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
                beanFactory.registerBeanDefinition("dyTokenService", BeanDefinitionBuilder.genericBeanDefinition(aClass).getRawBeanDefinition());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
