package com.smm.framework.config.swagger;

import lombok.Data;

/**
 * @author CHX
 * @description 配置Swagger Docket 的信息
 * @date 2019-11-04
 */
@Data
public class SwaggerApiInfo {

    private String groupName;

    private String basePackage;

    private String version;

    public SwaggerApiInfo() {
        super();
    }

    public SwaggerApiInfo(String groupName, String basePackage, String version) {
        this.groupName = groupName;
        this.basePackage = basePackage;
        this.version = version;
    }
}
