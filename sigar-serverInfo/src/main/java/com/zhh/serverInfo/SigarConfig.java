package com.zhh.serverInfo;

import org.hyperic.jni.ArchNotSupportedException;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;

/**
 * @Author:zhh
 * @Date:Created in 10:32 2019/6/19 0019
 */

@Configuration
public class SigarConfig {
    private static Logger log = LoggerFactory.getLogger(SigarConfig.class);

    //静态代码块
    static {
        try {
            initSigar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //初始化sigar的配置文件
    public static void initSigar() throws IOException {
        SigarLoader loader = new SigarLoader(Sigar.class);
        String lib = null;
        System.out.println("aaaaaaaaaaaaaaaaaaa");
        try {
            lib = loader.getLibraryName();
            log.info("init sigar so文件====================="+lib);
        } catch (ArchNotSupportedException var7) {
            log.error("initSigar() error:{}",var7.getMessage());
        }
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/sigar.so/" + lib);
        if (resource.exists()) {
            InputStream is = resource.getInputStream();
            File tempDir = new File("./var/log");
            if (!tempDir.exists()){
                tempDir.mkdirs();
            }
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(tempDir, lib), false));
            int lentgh = 0;
            while ((lentgh = is.read()) != -1){
                os.write(lentgh);
            }

            is.close();
            os.close();
            String path = System.setProperty("org.hyperic.sigar.path", tempDir.getCanonicalPath());
            log.info("======================org.hyperic.sigar.path:"+path);
        }

    }
}