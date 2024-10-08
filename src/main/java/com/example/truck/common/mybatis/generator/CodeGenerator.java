package com.example.truck.common.mybatis.generator;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.yaml.YamlUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.truck.common.mybatis.entity.BaseEntity;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * code generator
 */
public class CodeGenerator {

    public static void main(String[] args) {
        JSONObject defaultConfig = JSONUtil.parseObj(YamlUtil.loadByPath("application.yaml"));
        String active = defaultConfig.getJSONObject("spring").getJSONObject("profiles").getStr("active");
        JSONObject activeConfig = JSONUtil.parseObj(YamlUtil.loadByPath("application-" + active + ".yaml"));
        JSONObject databaseInfo = activeConfig.getJSONObject("spring").getJSONObject("datasource");
        // config param
        String moduleName = args[0];
        String group = args[1];
        String filePath = new File(System.getProperty("user.dir")) + "/src/main/";
        FastAutoGenerator.create(databaseInfo.getStr("url"), databaseInfo.getStr("username"), databaseInfo.getStr("password"))
                .globalConfig((scanner, builder) -> {
                    builder.author(scanner.apply("please enter author's name"))
                            .disableOpenDir()
                            .outputDir(filePath + "java");
                })
                .packageConfig(builder -> {
                    builder.parent(group)
                            .moduleName(moduleName)
                            .pathInfo(Collections.singletonMap(OutputFile.xml, filePath + "resources/mapper"));
                })
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("please enter table's name")))
                            // config controller
                            .controllerBuilder()
                            .enableRestStyle()
                            // config mapper
                            .mapperBuilder()
                            // config entity
                            .entityBuilder()
                            .enableLombok()
                            .enableChainModel()
                            .enableColumnConstant()
                            .superClass(BaseEntity.class)
                            .addSuperEntityColumns(BaseEntity.ID)
                            .javaTemplate("/mybatis/entity.java");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
