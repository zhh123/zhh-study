package read.resource.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import read.resource.file.ReadXlsx;
import read.resource.file.readfile.ReadFiles;

/**
 * @Author:zhh
 * @Date:Created in 17:25 2019/6/24 0024
 */
@Component
public class ServerStart implements ApplicationRunner {

    @Autowired
    ReadFiles readFiles;

    @Autowired
    ReadXlsx readXlsx;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       /* List<Integer> list = readFiles.readFile();
        list.forEach(value -> System.out.println(value));*/
       //readXlsx.readXlsx();
        readXlsx.springReadXlsx();
    }
}