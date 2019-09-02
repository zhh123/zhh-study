package read.resource.file;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zhh
 * @Date:Created in 15:25 2019/6/25 0025
 */
@Component
public class ReadXlsx {
    /**
     * 流读取文件
     * @return
     */
    public Map<Integer,String> readXlsx(){
        Map<Integer,String> result = new HashMap<>();
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("model.xlsx");
            System.out.println("aaaa: "+(inputStream == null));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            Sheet sheet = xssfWorkbook.getSheetAt(0);
            int firstRowIndex = sheet.getFirstRowNum() + 1;
            for(int i = firstRowIndex;i <= sheet.getLastRowNum();i ++){
                Row row = sheet.getRow(i);
                if(row != null){
                    int model = (int)row.getCell(0).getNumericCellValue();
                    String serverNode = row.getCell(1).getStringCellValue();
                    result.put(model,serverNode);
                    System.out.println(model +" ------> "+serverNode);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * spring文件读取工具
     */
    private ResourceLoader resourceLoader = new FileSystemResourceLoader();

    //spring文件读取工具
    public Map<Integer,String> springReadXlsx(){
        Map<Integer,String> result = new HashMap<>();
        try{
            //可以自动区分uri和绝对路径
            Resource fileResource = resourceLoader.getResource("classpath:/model.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileResource.getInputStream());
            Sheet sheet = xssfWorkbook.getSheetAt(0);
            int firstRowIndex = sheet.getFirstRowNum() + 1;
            for(int i = firstRowIndex;i <= sheet.getLastRowNum();i ++){
                Row row = sheet.getRow(i);
                if(row != null){
                    int model = (int)row.getCell(0).getNumericCellValue();
                    String serverNode = row.getCell(1).getStringCellValue();
                    result.put(model,serverNode);
                    System.out.println(model +" ------> "+serverNode);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}