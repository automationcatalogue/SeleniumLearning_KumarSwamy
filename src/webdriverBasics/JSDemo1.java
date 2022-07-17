package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo1 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testcatalogue-trials7501.orangehrmlive.com/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById('txtUsername').value='Admin'");
        //driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

        //driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        WebElement element_Password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        js.executeScript("arguments[0].value='Admin@123'",element_Password);

        WebElement element_LoginBtn=driver.findElement(By.xpath("//button[text()='Login']"));


        js.executeScript("arguments[0].click();",element_LoginBtn);
        System.out.println("Login button is clicked");

        //To scroll down for 50-pixel
        js.executeScript("window.scrollBy(0,50)");
        Thread.sleep(4000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
