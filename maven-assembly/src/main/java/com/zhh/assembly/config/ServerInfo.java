package com.zhh.assembly.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 17:03 2019/6/3 0003
 */

@Component
@ConfigurationProperties(prefix = "serverinfo")
public class ServerInfo {
    private String name;
    private int port;
    private String host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}