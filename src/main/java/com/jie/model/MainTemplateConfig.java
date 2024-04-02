package com.jie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态模板配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainTemplateConfig {
    /**
     * 是否生成循环
     */
    private boolean loop = true;
    /**
     * 作者注释
     */
    private String author = "jie";
    /**
     * 输出信息
     */
    private String outputText = "sum = ";

}
