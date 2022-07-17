package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://testcatalogue-trials7501.orangehrmlive.com/");

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
        System.out.println("Login button is invisible");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        WebElement login_btn=driver.findElement(By.xpath("//button[@type='submit']"));
        login_btn.click();
        System.out.println("Login button is clicked");


        driver.findElement(By.cssSelector("a[data-automation-id='menu_pim_viewEmployeeList'].top-level-menu-item")).click();
        System.out.println("Employee list is clicked");



        WebElement element_addBtn=driver.findElement(By.xpath("//a[@id='addEmployeeButton']"));
        wait.until(ExpectedConditions.elementToBeClickable(element_addBtn));
        element_addBtn.click();
        System.out.println("Add button is clicked");
    }
}
