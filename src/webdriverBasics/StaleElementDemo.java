package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementDemo {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
        System.out.println("Mobiles link is clicked");
        driver.findElement(By.xpath("//span[text()='Last 30 days']")).click();
        System.out.println("Last 30 days link is clicked");
        for(int i=0;i<=2;i++){
            try{
                driver.findElement(By.xpath("//span[@data-component-type='s-search-results']//child::div[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//h2/a")).click();
                System.out.println("First Search item is clicked");
            }catch (StaleElementReferenceException se){
                Thread.sleep(1000);
                System.out.println("Stale Element reference exception occurred while clicking first result");
            }catch (Exception e){
                e.printStackTrace();
                System.err.println(e);
                System.exit(0);
            }
        }

    }
}
