package com.scaffolding.learn.utils;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/28 19:25
 */
public class DocUtils {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\ideause\\java\\springboot\\security-learn3"); // 项目根目录
        config.setProjectName("security-learn3"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\ideause\\java\\springboot\\security-learn3"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
