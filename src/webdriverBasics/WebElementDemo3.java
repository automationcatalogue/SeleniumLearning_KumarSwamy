package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebElementDemo3 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");

        driver.manage().window().maximize();

        String parentSession=driver.getWindowHandle();
        System.out.println("Parent session ID is :"+parentSession);

        driver.findElement(By.xpath("//*[@id='register_Layer']/div")).click();
        System.out.println("Register button is clicked");

        Set<String> sessions=driver.getWindowHandles();
        System.out.println("Number of Sessions are :"+sessions.size());

        for(String sesion:sessions){
            driver.switchTo().window(sesion);
        }
        System.out.println("Switched into latest session");

        Thread.sleep(4000);
        driver.findElement(By.id("name")).sendKeys("Sagar");

        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(parentSession);
        System.out.println("Switched to parent window");




    }
}
