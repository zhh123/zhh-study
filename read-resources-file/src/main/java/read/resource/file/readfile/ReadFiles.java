package read.resource.file.readfile;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhh
 * @Date:Created in 17:24 2019/6/24 0024
 */
@Component
public class ReadFiles {
    public  List<Integer> readFile(){
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("model.txt");
        List<Integer> list = new ArrayList<>();
        try{
            InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bfReader = new BufferedReader(reader);
            String tmpContent = null;
            while((tmpContent = bfReader.readLine()) != null){
                list.add(Integer.parseInt(tmpContent));
            }
            bfReader.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}