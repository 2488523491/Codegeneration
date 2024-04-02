package com.jie.generator;

import com.jie.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.val;

import java.io.File;
import java.io.IOException;

public class MianTemplete {
    public static void main(String[] args) throws IOException, TemplateException {
        //获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        //输入路径：ACM 示例代码模板目录
        String inputPath = new File("D:\\spacework\\jie-generator\\jie-generator\\jie-generator-demo-projects\\acm-template").getAbsolutePath();
        String outputPath = parentFile.getAbsolutePath();
        File inputPathFile = new File(inputPath);
        File outputPathFile = new File(outputPath);
        StaticGenerage.copyFileByhutool(inputPathFile,outputPathFile);
    }
}
