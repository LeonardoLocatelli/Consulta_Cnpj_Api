package br.com.desafioinspiratech.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.DocExpansion
import springfox.documentation.swagger.web.OperationsSorter
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SpringConfig : WebMvcConfigurationSupport() {


    @Bean
    open fun apiDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("br.com.desafioinspiratech.controller"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(apiInfo)
    }

    val apiInfo: ApiInfo
        get() = ApiInfo(
            "",
            "", "1",
            "",
            Contact(
                "",
                "", ""
            ),
            "Politicas de Privacidade",
            "", emptyList()
        )

    @Bean
    open fun uiConfig(): UiConfiguration {
        return UiConfigurationBuilder.builder()
            .docExpansion(DocExpansion.LIST)
            .operationsSorter(OperationsSorter.METHOD)
            .build()
    }

    public override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs?group=restful-api")
        registry.addRedirectViewController("/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui")
        registry.addRedirectViewController(
            "/swagger-resources/configuration/security",
            "/swagger-resources/configuration/security"
        )
        registry.addRedirectViewController("/swagger-resources", "/swagger-resources")
        registry.addRedirectViewController("/", "/swagger-ui.html")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


}