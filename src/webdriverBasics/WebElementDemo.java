package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        driver.manage().window().maximize();

        //Username
        By username_locator=By.id("email");
        WebElement element_username=driver.findElement(username_locator);
        element_username.sendKeys("sagar@gmail.com");
        System.out.println("username is entered");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("kumar@gmail.com");

        //password
        driver.findElement(By.name("pass")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        //Login button
        driver.findElement(By.name("login")).submit();
        System.out.println("Login button is clicked");

    }
}
