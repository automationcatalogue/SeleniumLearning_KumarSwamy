package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("India");
        driver.findElement(By.name("q")).submit();

        String url=driver.getCurrentUrl();
        System.out.println("Curent URL is :"+url);

        String pageSource=driver.getPageSource();
        System.out.println("PageSource is :"+pageSource);

    }
}
