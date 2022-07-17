package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo4 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://automatecatalog-trials7401.orangehrmlive.com/auth/login");
        driver.manage().window().maximize();

        //username
        String s1=driver.findElement(By.name("txtUsername")).getAttribute("placeholder");
        System.out.println(s1);
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");

        //password
        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        String s4=driver.findElement(By.id("txtPassword")).getTagName();
        System.out.println(s4);

        //Login button
        int x=driver.findElement(By.xpath("//*[@id='divLogin']/div[2]/div/form/div[3]/button")).getLocation().getX();
        int y=driver.findElement(By.xpath("//*[@id='divLogin']/div[2]/div/form/div[3]/button")).getLocation().getY();
        System.out.println("X-Coordinate value is :"+x+"Y-Coordinate value is :"+y);
        driver.findElement(By.xpath("//*[@id='divLogin']/div[2]/div/form/div[3]/button")).click();


        //PIM
        driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/a/span[2]")).click();
        Thread.sleep(2000);

        //Add Employee Link
        driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']/span[2]")).click();
        Thread.sleep(12000);

        //firstname text-box
        driver.findElement(By.id("first-name-box")).sendKeys("Sagar");

        Thread.sleep(4000);
        //clicking for more options
       // driver.findElement(By.xpath("//*[@id='modal-holder']/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[4]/div/div/span/div/label")).click();

        boolean flag=driver.findElement(By.xpath("//*[@id='modal-holder']/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[5]/div/div[2]/div/div/div[1]/input")).isSelected();
        System.out.println(flag);

        flag=driver.findElement(By.xpath("//*[@id='modal-holder']/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[5]/div/div[2]/div/div/div[2]/input")).isSelected();
        System.out.println(flag);

        flag=driver.findElement(By.id("modal-save-button")).isEnabled();
        System.out.println("Enabled or not ?"+flag);

        String s2=driver.findElement(By.id("modal-save-button")).getCssValue("color");
        System.out.println(s2);

        String s3=driver.findElement(By.id("modal-save-button")).getCssValue("font-size");
        System.out.println(s3);

        int width=driver.findElement(By.id("modal-save-button")).getSize().getWidth();
        int height=driver.findElement(By.id("modal-save-button")).getSize().getHeight();
        System.out.println("Width of webelement is :"+width+"Height of the webelement is :"+height);

        String text=driver.findElement(By.xpath("//*[@id='modal-holder']/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[6]/div/div/div/div[2]/div/small")).getText();
        System.out.println("Text is :"+text);


    }
}
