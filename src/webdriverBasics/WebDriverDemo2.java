package webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo2 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

    }
}
