package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testcatalogue-trials7501.orangehrmlive.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        Actions action = new Actions(driver);

        //username
        WebElement element_username=driver.findElement(By.id("txtUsername"));
        action.sendKeys(element_username,"Admin");

        WebElement element_Password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        action.moveToElement(element_Password).click().sendKeys("Admin@123").build().perform();

        WebElement element_LoginBtn=driver.findElement(By.xpath("//button[text()='Login']"));

        action.click(element_LoginBtn).perform();
        System.out.println("Login button is clicked");
    }
}
