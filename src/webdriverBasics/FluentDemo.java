package webdriverBasics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentDemo {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver","C:\\AutomationCatalogue\\Drivers\\Firefox\\geckodriver\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        //System.setProperty("webdriver.opera.driver","C:\\AutomationCatalogue\\Drivers\\Opera\\operadriver\\operadriver.exe");
        //WebDriver driver = new OperaDriver();

        System.setProperty("webdriver.edge.driver","C:\\AutomationCatalogue\\Drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://testcatalogue-trials7501.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        WebElement login_btn=driver.findElement(By.xpath("//button[@type='submit']"));
        login_btn.click();
        System.out.println("Login button is clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList'][contains(text(),'Employee List')]")).click();
        System.out.println("Employee List link is clicked");

        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        wait.until(
                new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver driver){
                        WebElement element=driver.findElement(By.cssSelector(".pim-container div div table tbody tr:nth-child(3)>td:nth-child(1)"));
                        Boolean flag=element.isDisplayed();
                        if(flag){
                            System.out.println("Element is Displayed");
                            try{
                                driver.findElement(By.xpath("//i[text()='add']")).click();
                                System.out.println("Add button is clicked");
                                return true;
                            }catch (ElementNotInteractableException e){
                                return false;
                            }
                        }else{
                            System.out.println("Element is not Displayed");
                            return false;
                        }
                    }
                }
        );


    }
}
