package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TC02_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://testautomation9-trials7501.orangehrmlive.com");
        driver.manage().window().maximize();

        //username
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        //password
        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        //Login button
        driver.findElement(By.xpath("//*[@id='divLogin']/div[2]/div/form/div[3]/button")).click();
        //dashboard availability
        WebElement dashboard= driver.findElement(By.xpath("//a[@class='top-level-menu-item forced-active active']"));
        boolean b=dashboard.isDisplayed();
        if (b=true){
            System.out.println("dash board available");

        }else{
            System.out.println("not available");
        }
        //
        driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewSystemUsers'][@id='menu_item_81'][1]")).click();
        System.out.println("click on HR Administrator");
        //add user button
        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("add user button clicked");

        //name
        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys("Aaron Hamilton");
        Thread.sleep(10000);
        System.out.println("name entered");
        //username
        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[2]/div[2]/input")).sendKeys("apple");
        System.out.println("username entered");

        //close
        driver.findElement(By.xpath("//button[@class='btn btn-close']")).click();
        //reopen n enter
        //add user button
        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("add user button clicked");

        //name
        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys("Aaron Hamilton");
        Thread.sleep(10000);
        System.out.println("name entered");
        //username
        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[2]/div[2]/input")).sendKeys("bananaxyz");
        System.out.println("username entered");




        //ESS role
        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[1]']/div[1]/div[1]/div[1]/div[1]")).click();
        System.out.println("ESS role clicked");
        Select ess=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[1]']/div[1]/div[1]/div[1]/div[1]/select")));
        ess.selectByVisibleText("Default ESS");

        System.out.println("selected selected");

        //supervisor role
        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[1]']/div[1]/div[2]/div[1]/div[1]")).click();
        System.out.println("supervisor role clicked");
        Select supervisor=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[1]']/div[1]/div[2]/div[1]/div[1]/select")));
        supervisor.selectByVisibleText("Default Supervisor");
        System.out.println("selected selected");




        //admin role

        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[2]']/div[1]/div[1]/div[1]/div[1]")).click();
        System.out.println("supervisor role clicked");
        Select admn=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[2]']/div[1]/div[1]/div[1]/div[1]/select")));
        admn.selectByVisibleText("Asset Manager");
        System.out.println("Asset Manager selected");

        //password give
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Asqf1234@");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("Asqf1234@");
        Thread.sleep(2000);
        //save
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("save clicked");
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//input[@ng-model-options='form.ngModelOptions']")).click();
        //all regions
        //driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[1]/span[1]/div[1]/input")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='allRegions']")));
        Thread.sleep(5000);
        //select regions

        driver.findElement((By.xpath("//div[@class='form-group col-6']/oxd-multiselect/div[1]/div[1]/div[1]/div[1]/ul/li[2]"))).click();
        driver.findElement((By.xpath("//div[@class='form-group col-6']/oxd-multiselect/div[1]/div[1]/div[1]/div[1]/ul/li[4]"))).click();
        driver.findElement((By.xpath("//div[@class='form-group col-6']/oxd-multiselect/div[1]/div[1]/div[1]/div[1]/ul/li[6]"))).click();

        driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();










    }

}

//

