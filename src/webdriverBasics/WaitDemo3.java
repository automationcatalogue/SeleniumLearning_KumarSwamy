package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.partialLinkText("Computer")).click();
        System.out.println("Computers menu is clicked");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[title='Show products in category Desktops']")));
        driver.findElement(By.cssSelector("img[title='Show products in category Desktops']")).click();
        System.out.println("Desktops image is clicked");

        WebElement element_text=driver.findElement(By.xpath("//div[@class='filter-title']/strong"));
        wait.until(ExpectedConditions.textToBePresentInElement(element_text,"Filter by price"));
        driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
        System.out.println("Add to Cart button is clicked");
        wait.until(ExpectedConditions.titleContains("Demo Web Shop. Desktops"));
        wait.until(ExpectedConditions.urlContains("http://demowebshop.tricentis.com/build-your-cheap-own-computer"));

        driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
    }
}
