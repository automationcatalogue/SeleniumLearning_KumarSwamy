package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_DemoWebShop_PlaceOrder {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        String t= driver.getTitle();
        System.out.println("title of page : "+t);
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("aarosagarch@gmail.com");
        driver.findElement(By.xpath("//input[@class='password'][@id='Password']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//input[@class='button-1 login-button'] ")).click();
        driver.findElement(By.xpath("//input[@id='small-searchterms'][@value='Search store']")).sendKeys("Blue Jeans");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button'][@value='Search']")).click();
        driver.findElement(By.xpath("//div[@class='search-results']/div/div/div/div/a/img[@title='Show details for Blue Jeans'][@alt='Picture of Blue Jeans']")).click();
        driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
        System.out.println("add to cart");
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        System.out.println("shopping cart");



        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@value='checkout']")).click();
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input[@value='Continue'][@title='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='shipping-buttons-container']/input[@class='button-1 new-address-next-step-button'][@title='Continue']")).click();Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/input[@class='button-1 shipping-method-next-step-button']")).click();Thread.sleep(2000);
        System.out.println("payment options clicked");
        driver.findElement(By.xpath("//input[@value='Payments.CashOnDelivery']")).click();
        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
        System.out.println("cash on delivery clicked and continue clicked");
        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
        System.out.println("cash on delivery clicked");Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();Thread.sleep(2000);
        System.out.println("cash on delivery confirmed");
        driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();
        System.out.println("order success");
        driver.findElement(By.xpath("//a[text()='Log out']")).click();
        System.out.println("log out success");




        //driver.findElement(By.xpath("//input[@id='paymentmethod_2']")).click();Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();Thread.sleep(2000);

        //System.out.println("log out clicked");Thread.sleep(2000);








    }
}
