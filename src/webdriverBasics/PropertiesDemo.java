package webdriverBasics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
        prop.load(fis);

        String data = prop.getProperty("browser");
        System.out.println(data);
        data=prop.getProperty("chromeDriverExePath");
        System.out.println(data);
        data=prop.getProperty("orangeHRMURL");
        System.out.println(data);

        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
        prop.load(fis);
        prop.setProperty("browser","firefox");
        prop.store(fos,"browsername updated");
        fos.close();
        fis.close();
    }
}
