package com.dyj.spring.config;

import com.dtflys.forest.springboot.ForestAutoConfiguration;
import com.dtflys.forest.springboot.annotation.ForestScan;
import com.dyj.spring.utils.SpringUtils;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author danmo
 * @date 2024-04-03 10:20
 **/
@ForestScan("com.dyj.**.client")
@AutoConfigureBefore(ForestAutoConfiguration.class)
@Configuration
@Import({SpringUtils.class})
public class DyScannerConfiguration {
}
