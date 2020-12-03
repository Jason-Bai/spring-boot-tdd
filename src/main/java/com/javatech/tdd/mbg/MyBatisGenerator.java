package com.javatech.tdd.mbg;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis生成器
 * @author baiyu
 * @Desc
 * @date 2020/12/1
 */
public class MyBatisGenerator {
    /**
     * 生成代码
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // MBG 执行过程中的警告信息
        List<String> warnings = new ArrayList<String>();

        // 读取我们的 MBG 配置文件
        InputStream is = MyBatisGenerator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        // 当生成的代码重复时，覆盖原代码
        DefaultShellCallback callback = new DefaultShellCallback(true);

        // 创建 MBG
        org.mybatis.generator.api.MyBatisGenerator myBatisGenerator = new org.mybatis.generator.api.MyBatisGenerator(config, callback, warnings);

        // 执行生成代码
        myBatisGenerator.generate(null);

        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
