package httpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 14:00 2019/7/11 0011
 */
@Component
public class ServerStart implements ApplicationRunner {

    @Autowired
    HttpUtil httpUtil;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============== 开始发送get请求 ===============");
        String response = httpUtil.sendGet("httpClientTest","http://112.74.195.31:8080/test");
        System.out.println("相应结果： "+response);
    }
}