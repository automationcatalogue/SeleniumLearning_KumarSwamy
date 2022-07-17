package webdriverBasics;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelDemo {
    public static void main(String[] args) throws Exception{
        String projectPath=System.getProperty("user.dir");
        System.out.println("projectPath :"+projectPath);

        FileInputStream fis = new FileInputStream(projectPath+"\\TestData\\AutomationCatalogue.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh=wbk.getSheet("AddEmployee");
        XSSFRow row=sh.getRow(5);
        XSSFCell cell=row.getCell(7);
        String data=cell.getStringCellValue();
        System.out.println("Data is :"+data);

        System.out.println("********** Complete 3rd row data is : ************");
        row=sh.getRow(3);
        for(int i=0;i<row.getLastCellNum();i++){
            data=row.getCell(i).getStringCellValue();
            System.out.println(data);
        }

        System.out.println("********* Complete LastName cell Data is ***********");
        for(int i=0;i<sh.getLastRowNum();i++){
            data=sh.getRow(i).getCell(6).getStringCellValue();
            System.out.println(data);
        }

        System.out.println("**************** Complete Excel Data is  *************");
        for(int i=0;i<=sh.getLastRowNum();i++){
                for(int j=0;j<sh.getRow(i).getLastCellNum();j++){
                    data=sh.getRow(i).getCell(j).getStringCellValue();
                    System.out.print(data+"\t");
                }
            System.out.println();
        }
    }
}
