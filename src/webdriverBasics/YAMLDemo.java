package webdriverBasics;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;

public class YAMLDemo {
    public static void main(String[] args) throws Exception{
        Yaml ob = new Yaml();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Automation.yaml");
        HashMap<String, String> map = (HashMap<String, String>) ob.load(fis);
        String browserName=map.get("browser");
        System.out.println("BrowserName is :"+browserName);

        String driverPath = map.get("chromeDriverExePath");
        System.out.println("DriverPath is :"+driverPath);

        FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\TestData\\Automation.yaml");
        map.put("browser","firefox");
        ob.dump(map,fw);
        fw.close();

    }
}
