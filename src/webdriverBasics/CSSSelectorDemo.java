package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomate-trials7501.orangehrmlive.com/auth/login");

        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[id='txtPassword'][class='password-input']")).sendKeys("2sVb5PH@qH");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Thread.sleep(3000);
        driver.get("https://www.amazon.in/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Kids toys");
        driver.findElement(By.cssSelector("#nav-search-submit-button[type='submit']")).click();
    }
}
