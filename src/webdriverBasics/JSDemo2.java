package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo2 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testcatalogue-trials7501.orangehrmlive.com/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById('txtUsername').value='Admin'");
        WebElement element_Password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        js.executeScript("arguments[0].value='Admin@123'",element_Password);
        WebElement element_LoginBtn=driver.findElement(By.xpath("//button[text()='Login']"));
        js.executeScript("arguments[0].click();",element_LoginBtn);
        System.out.println("Login button is clicked");

        driver.manage().window().maximize();
        WebElement element_LatestNews=driver.findElement(By.xpath("//span[text()='Latest News']"));
        js.executeScript("arguments[0].scrollIntoView(true);",element_LatestNews);

        Thread.sleep(2000);
        js.executeScript("history.go(0)");
        System.out.println("Browser window is refereshed");

        Thread.sleep(2000);
        String title=js.executeScript("return document.title;").toString();
        System.out.println("Title of the application is :"+title);

        Thread.sleep(2000);
        String url=js.executeScript("return document.URL").toString();
        System.out.println("Current URL is :"+url);

        Thread.sleep(2000);
        String domain = js.executeScript("return document.domain").toString();
        System.out.println("Domain of the application is :"+domain);

        Thread.sleep(2000);
        String innerText=js.executeScript("return document.documentElement.innerText").toString();
        System.out.println(innerText);

        Thread.sleep(2000);
        String innerHtml=js.executeScript("return document.documentElement.innerHTML").toString();
        System.out.println(innerHtml);

    }
}
