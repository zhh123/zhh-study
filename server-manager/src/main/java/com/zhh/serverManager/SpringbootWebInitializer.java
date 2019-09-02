package com.zhh.serverManager;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.swing.*;

/**
* @ClassName: SpringbootWebInitializer
* @Description: web容器中进行部署
* @author zhh
* @date 2019年6月18日
*
*/
public class SpringbootWebInitializer extends SpringBootServletInitializer{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(SpringBootStart.class);
    }
}
