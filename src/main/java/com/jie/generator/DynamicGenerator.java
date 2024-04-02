package com.jie.generator;


import com.jie.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DynamicGenerator {
    public static void doGenerator(String inputPath,String outputPath,MainTemplateConfig mainTemplateConfig) throws IOException, TemplateException {
        //new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        //设置所用的字符集
        configuration.setDefaultEncoding("utf-8");
        //创建模板对象，加载指定模板
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());
        Template template = configuration.getTemplate(new File(inputPath).getName());
        //创建数据模型（由前端传入）//生成
        FileWriter out = new FileWriter(outputPath);
        template.process(mainTemplateConfig,out);
        out.close();
    }


}
