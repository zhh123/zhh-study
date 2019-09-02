package httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 13:47 2019/7/11 0011
 */
@Component
public class HttpUtil {

    public String sendGet(String data,String url){
        String urlNameString = url+"?test="+data;
        String reponseData = null;
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000)
                    .setRedirectsEnabled(true)
                    .build();

            // 根据地址获取请求
            HttpGet httpGet = new HttpGet(urlNameString);//这里发送get请求
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                System.out.println("HTTP请求未成功！HTTP Status Code:" + response.getStatusLine());
            }
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String reponseContent = EntityUtils.toString(httpEntity,"UTF-8");
                EntityUtils.consume(httpEntity);//释放资源
                System.out.println("响应内容：" + reponseContent);
                reponseData = reponseContent;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return reponseData;
    }
}