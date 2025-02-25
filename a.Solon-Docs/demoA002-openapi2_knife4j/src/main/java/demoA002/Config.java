package demoA002;

import com.github.xiaoymin.knife4j.solon.extension.OpenApiExtensionResolver;
import demoA002.model.HttpCodes;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import io.swagger.models.parameters.HeaderParameter;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Result;
import org.noear.solon.docs.ApiEnum;
import org.noear.solon.docs.DocDocket;
import org.noear.solon.docs.models.ApiInfo;

@Configuration
public class Config {
    @Inject
    OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * 基于配置构建（由 solon.docs 自动生成）
     */
    @Bean
    public void adminApi(@Inject("adminApi") DocDocket docket) {
        //docket.globalResult(SwaggerRes.class);
        docket.globalResponseCodes(new HttpCodes());
        //docket.securityDefinitionInHeader("token");
        docket.basicAuth(openApiExtensionResolver.getSetting().getBasic());
        docket.vendorExtensions(openApiExtensionResolver.buildExtensions());
    }

    /**
     * 基于代码构建
     */
    @Bean("appApi")
    public DocDocket appApi() {
        return new DocDocket()
                .groupName("app端接口")
                .schemes(ApiEnum.SCHEMES_HTTP)
                .globalResult(Result.class)
                .globalResponseInData(true)
                .apis("demoA002.controller.app");
                //.securityDefinitionInHeader("token");

    }

    /**
     * 基于代码构建
     */
    @Bean("gatewayApi")
    public DocDocket gatewayApi() {
        return new DocDocket()
                .groupName("gateway端接口")
                .schemes(ApiEnum.SCHEMES_HTTP)
                .globalResult(Result.class)
                .globalResponseInData(true)
                .securityExtensions("TOKEN", new ApiKeyAuthDefinition().in(In.HEADER))
                .vendorExtensions("TOKEN", "xxx")
                .globalParams(new HeaderParameter().name("token").required(true))
                .apis("demoA002.controller.api2");
                //.securityDefinitionInHeader("token");

    }

    //    @Bean("appApi")
    public DocDocket appApi2() {
        return new DocDocket()
                .groupName("app端接口")
                .info(new ApiInfo().title("在线文档")
                        .description("在线API文档")
                        .termsOfService("https://gitee.com/noear/solon")
                        .contact("demo", "https://gitee.com/noear/solon", "demo@foxmail.com")
                        .version("1.0"))
                .schemes(ApiEnum.SCHEMES_HTTP)
                .globalResponseInData(true)
                .globalResult(Result.class)
                .apis("demoA002.controller.app");
                //.securityDefinitionInHeader("token");

    }
}
