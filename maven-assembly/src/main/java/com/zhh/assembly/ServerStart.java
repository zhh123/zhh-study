package com.zhh.assembly;

import com.zhh.assembly.config.ServerInfo;
import com.zhh.assembly.util.ClassPathFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * @Author:zhh
 * @Date:Created in 17:04 2019/6/3 0003
 */
@Component
public class ServerStart implements ApplicationRunner {

    @Autowired
    ServerInfo serverInfo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("serverInfo name: "+serverInfo.getName());

        File testFile = ClassPathFileUtil.getFile("test.txt");
        List<String> testText = FileUtils.readLines(testFile,"UTF-8");
        System.out.println("testText: "+testText);
    }
}