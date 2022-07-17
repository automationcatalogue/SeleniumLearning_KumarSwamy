package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionDemo3 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/students/actions");
        driver.manage().window().maximize();

        WebElement element_Home = driver.findElement(By.linkText("Home"));
        Actions action = new Actions(driver);
        action.contextClick(element_Home).build().perform();

        Thread.sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        System.out.println("DOWN button is clicked one time");

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        System.out.println("DOWN button is clicked second time");

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        System.out.println("DOWN button is clicked third time");

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("ENTER button is clicked");

    }
}
