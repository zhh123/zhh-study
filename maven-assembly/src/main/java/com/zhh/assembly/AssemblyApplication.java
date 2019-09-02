package com.zhh.assembly;

import com.zhh.assembly.util.ClassPathFileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:zhh
 * @Date:Created in 15:27 2019/6/3 0003
 */
@SpringBootApplication
public class AssemblyApplication {
    public static void main(String[] args){
        SpringApplication.run(AssemblyApplication.class,args);
      /*  try {
            ClassPathFileUtil.getFile("test.txt");
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}