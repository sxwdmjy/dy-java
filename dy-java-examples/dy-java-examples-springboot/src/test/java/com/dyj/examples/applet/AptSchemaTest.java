package com.dyj.examples.applet;

import com.dyj.applet.DyAppletClient;
import com.dyj.applet.domain.query.GenerateSchemaQuery;
import com.dyj.applet.domain.vo.GenerateSchemaVo;
import com.dyj.common.domain.DySimpleResult;
import com.dyj.examples.DyJavaExamplesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class AptSchemaTest {

    @Test
    public void generateSchema() {
        DySimpleResult<GenerateSchemaVo> dySimpleResult = DyAppletClient.getInstance().generateSchema(GenerateSchemaQuery.builder().build());
        System.out.println(dySimpleResult);
    }
}
