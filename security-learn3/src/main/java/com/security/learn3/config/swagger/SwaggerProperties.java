package com.security.learn3.config.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:09
 */
@ConfigurationProperties("swagger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerProperties {
    private String title;
    private String basepackage;
    private String version;
    private String contractName;
    private String description;
    private String contractUrl;
    private String contractEmail;
}