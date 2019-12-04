package com.javainsider.springbootneo4j.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Optional;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.javainsider.springbootneo4j" })
public class SwaggerConfig implements WebMvcConfigurer {

	private static final Set<String> DEFAULT_PRODUCE = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
	private static final Set<String> DEFAULT_CONSUME = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE));

	@Bean
	public Docket api() {

		ParameterBuilder headerParameterBuilder = new ParameterBuilder();
		headerParameterBuilder.name("X-JavaInsider-Auth").modelRef(new ModelRef("String")).parameterType("header")
				.defaultValue("rxg").required(true).build();

		List<Parameter> headerParameters = new ArrayList<>();
		headerParameters.add(headerParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).groupName("JavaInsider API V1").produces(DEFAULT_PRODUCE)
				.consumes(DEFAULT_CONSUME).select()
				.paths(Predicates.or(PathSelectors.regex("/actuator/.*"), PathSelectors.regex("/api/v1/.*"))).build()
				.genericModelSubstitutes(Optional.class).globalOperationParameters(headerParameters)
				.apiInfo(new ApiInfoBuilder().version("V1.0").title("JavaInsider neo4j Service")
						.description("JavaInsider neo4j service v1").build())
				.useDefaultResponseMessages(false);
	}
}
