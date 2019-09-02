package com.zhh.assembly.util;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * @Author:zhh
 * @Date:Created in 16:53 2019/6/3 0003
 */
public class ClassPathFileUtil {
    private static final String USER_DIR = "user.dir";
    private static final String BIN = "bin";
    private static final String CONFIG = "config";

    public static File getFile(String fileName) throws IOException {
        // 获取当前执行启动命令的路径
        String userDir = System.getProperty(USER_DIR);
        System.out.println("user.dir: "+userDir);

        File targetFile = null;
        if(userDir.startsWith("/")){
            System.out.println("生成环境读取文件...");
            File configDir = new File(userDir+"/"+CONFIG);
            targetFile = new File(configDir,fileName);
        }else{
            System.out.println("开发工具中读取文件...");
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            targetFile = classPathResource.getFile();
        }

       return targetFile;

    }
}