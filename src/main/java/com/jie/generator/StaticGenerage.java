package com.jie.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import com.jie.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class StaticGenerage {
    /**
     * 拷贝静态文件方法
     * 拷贝文件（hutool实现，会将输入目录完整拷贝到输入目录下）
     * 静态文本生成器
     * @param inputPathFlie
     * @param outputPathFlie
     */
    public static void copyFileByhutool(File inputPathFlie, File outputPathFlie) throws IOException, TemplateException {
        MainTemplateConfig config = new MainTemplateConfig(true,"介","答案为");
        if(inputPathFlie.isDirectory()){
            File files = new File(outputPathFlie, inputPathFlie.getName());
            if(!files.exists()){
                files.mkdirs();
            }
            File[] filesList = inputPathFlie.listFiles();
            if(ArrayUtil.isEmpty(filesList)){
                return;
            }
            for (File file : filesList) {
                //是目录
                if(file.isDirectory()){
                    copyFileByhutool(file,files);
                    //是文件
                }else {
                    if(file.getName().contains("Template")){
                        String absolutePath = file.getAbsolutePath();
                        Path destPath = outputPathFlie.toPath().resolve(inputPathFlie.getName());
                        String NdesPath = destPath.toString();
                        String NewdestPath = NdesPath + File.separator + "MainTemplate.java";
                        DynamicGenerator.doGenerator(absolutePath,NewdestPath,config);

                    }else {
                        Path destPath = outputPathFlie.toPath().resolve(inputPathFlie.getName());
                        Files.copy(inputPathFlie.toPath(),destPath,StandardCopyOption.REPLACE_EXISTING);
                    }

                }
            }

        }
    }


}
