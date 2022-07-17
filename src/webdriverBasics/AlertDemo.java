package webdriverBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.manage().window().maximize();
        WebElement element_iframe=driver.findElement(By.xpath("//frame[@name='login_page']"));

        driver.switchTo().frame(element_iframe);
        System.out.println("Switched into the iframe");

        driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
        System.out.println("Clicking on Continue button without userid");

        Thread.sleep(2000);

        Alert al=driver.switchTo().alert();
        al.accept();
        System.out.println("OK button is clicked");

    }
}
