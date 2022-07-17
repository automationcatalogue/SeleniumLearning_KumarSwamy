package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.google.com");

        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys("Admin");
        //driver.findElement(By.xpath("//*[@id='identifierNext']/div/button/span")).submit();

        boolean found=driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[3]/button")).isDisplayed();
        System.out.println("Forgot email link is displayed or not? "+found);

    }
}
