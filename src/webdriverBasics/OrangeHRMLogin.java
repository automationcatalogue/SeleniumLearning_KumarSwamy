package webdriverBasics;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class OrangeHRMLogin {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
        prop.load(fis);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");//To Ignore the certificate related errors
        options.addArguments("--headless");//To Ignore the certificate related errors

        System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverExePath"));
        WebDriver driver = new ChromeDriver(options);
        driver.get(prop.getProperty("orangeHRMURL"));
        driver.manage().window().maximize();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"\\screenshots\\OrangeHRM_Login_01.jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot is captured after loading the OrangeHRM URL");

        //username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //password
        driver.findElement(By.id("txtPassword")).sendKeys("Test@123");
        //Login button
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        String actualURL=driver.getCurrentUrl();
        if(actualURL.equalsIgnoreCase("https://testcatalogue-trials7501.orangehrmlive.com/client/#/dashboard")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
            src = ts.getScreenshotAs(OutputType.FILE);
            dest = new File(System.getProperty("user.dir")+"\\screenshots\\OrangeHRM_Login_02.jpg");
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot is captured for unsuccessful login");
        }
    }

}
