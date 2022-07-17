package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WithoutSelectDemo {
    public static void main(String[] args) throws Exception{
        String str="India Office";

        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://automatecatalog-trials7401.orangehrmlive.com/auth/login");
        driver.manage().window().maximize();

        //username
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");

        //password
        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");


        //Login button
        driver.findElement(By.xpath("//*[@id='divLogin']/div[2]/div/form/div[3]/button")).click();


        //PIM
        driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/a/span[2]")).click();
        Thread.sleep(2000);

        //Add Employee Link
        driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']/span[2]")).click();
        Thread.sleep(12000);

        //firstname text-box
        driver.findElement(By.id("first-name-box")).sendKeys("Sagar");

        driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
        System.out.println("Locations drop-down is clicked");

        List<WebElement> elements_Locations=driver.findElements(By.xpath("//div[@class='inner show']/ul/li"));
        System.out.println("Size of drop-down values are :"+elements_Locations.size());
        for(WebElement element:elements_Locations){
            String text=element.getText();
            if(text.equalsIgnoreCase("India Office")){
                element.click();
                System.out.println(text+" is selected from a drop-down");
                break;
            }
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
        System.out.println("Locations drop-down is clicked");

        System.out.println("Legacy approach - without foreach loop - using regular for loop");
        for(int i=1;i<elements_Locations.size();i++){
            WebElement element=driver.findElement(By.xpath("//div[@class='inner show']/ul/li["+i+"]/a/span"));
            String text=element.getText();
            if(text.equalsIgnoreCase("European Office")){
                element.click();
                System.out.println(text+" is selected from a dropd-down");
                break;
            }
        }
    }


}
