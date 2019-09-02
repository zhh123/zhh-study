package read.resource.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import read.resource.file.readfile.ReadFiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhh
 * @Date:Created in 17:04 2019/6/24 0024
 */
@SpringBootApplication
public class ReadResourcesStart {
    Logger logger = LoggerFactory.getLogger(ReadResourcesStart.class);

    @Autowired
    ReadFiles readFile;
    public static void main(String[] args){
        SpringApplication.run(ReadResourcesStart.class,args);

    }


}