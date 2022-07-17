package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC01_OrangeHRM_AddEmployee {
    public static void main(String[] args) throws Exception{
        String dob="10-July-1986";

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

        //EmployeeList
        driver.findElement(By.partialLinkText("Employee List")).click();
        System.out.println("Employee List link is clicked");

        //Add Employee button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addEmployeeButton")));

        driver.findElement(By.cssSelector("#addEmployeeButton")).click();
        System.out.println("Add Employee button is clicked");

        //FirstName
        driver.findElement(By.cssSelector("#first-name-box")).sendKeys("SeleniumABC");
        System.out.println("Firstname is entered");
        //LastName
        driver.findElement(By.cssSelector("#last-name-box")).sendKeys("XYZAutomation");
        System.out.println("Lastname is entered");

        //Location
        driver.findElement(By.cssSelector(".btn.dropdown-toggle")).click();
        System.out.println("Location is clicked");
        driver.findElement(By.xpath("//span[text()='Australia office']")).click();
        System.out.println("Location value is selected");

        //Next button
        driver.findElement(By.cssSelector("#modal-save-button")).click();
        System.out.println("Next button is clicked");

        //Date of Birth
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#emp_birthday")));
        driver.findElement(By.xpath("//input[@id='emp_birthday']//following-sibling::span[1]//i")).click();
        System.out.println("Date Picker icon is clicked");

        String expyear=dob.split("-")[2];
        driver.findElement(By.cssSelector(".select-wrapper.picker__select--year")).click();
        System.out.println("Year drop-down is clicked");
        List <WebElement> elements_year=driver.findElements(By.xpath("//input[@id='emp_birthday']//following-sibling::span[1]//div//ul[@class='dropdown-content select-dropdown active']/li/span"));
        for(WebElement ele_year:elements_year){
            String actyear=ele_year.getText();
            if(expyear.equalsIgnoreCase(actyear)){
                ele_year.click();
                System.out.println("Year is clicked");
                break;
            }
        }

        String expMonth=dob.split("-")[1];
        driver.findElement(By.cssSelector(".select-wrapper.picker__select--month")).click();
        System.out.println("Month drop-down is clicked");
        List<WebElement> elements_month=driver.findElements(By.xpath("//input[@id='emp_birthday']//following-sibling::span[1]/span/div//ul[@class='dropdown-content select-dropdown active']/li/span"));
        for(WebElement ele_month:elements_month){
            String actMonth=ele_month.getText();
            if(actMonth.equalsIgnoreCase(expMonth)){
                ele_month.click();
                System.out.println("Month is clicked");
                break;
            }
        }

        String expDate=dob.split("-")[0];
        List<WebElement> rows_dates=driver.findElements(By.xpath("//table[@class='picker__table']/tbody/tr"));
        First: for(WebElement row_date:rows_dates){
            List<WebElement> actualdates=row_date.findElements(By.xpath("td/div"));
            for(WebElement actDate:actualdates){
                String actualDate=actDate.getText();
                if(actualDate.equalsIgnoreCase(expDate)){
                    actDate.click();
                    System.out.println("Date is clicked");
                    break First;
                }
            }

        }

        //married
        driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[2]']/div/sf-decorator[2]/div/div/input")).click();
        System.out.println("drop down marital status clicked");
        driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[2]']/div/sf-decorator[2]/div/div/ul/li[2]")).click();
        System.out.println("married selected");
        //Gender
        driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[2]']/div/sf-decorator[3]/div/div/input")).click();
        System.out.println("drop down gender status clicked");
        driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[2]']/div/sf-decorator[3]/div/div/ul/li[3]")).click();
        System.out.println("male selected");
        //nationality
        driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[3]']/div/sf-decorator[1]/div/div/input")).click();
        System.out.println("drop down nationality clicked");
        String country="Indian";
        //driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[3]']/div/sf-decorator[1]/div/div/ul/li"));
        List<WebElement> countries=driver.findElements(By.xpath("//materializecss-decorator[@form='schemaForm.form[3]']/div/sf-decorator[1]/div/div/ul/li"));
        for(WebElement countrieslist:countries){
            String actcountry=countrieslist.getText();
            if(actcountry.equalsIgnoreCase(country)){
                countrieslist.click();
                System.out.println("Indian is clicked");
                break;
            }
        }
        //next button
        driver.findElement(By.xpath("//button[@class='btn btn-secondary right']")).click();


        //next page job title

        driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select-dropdown']")).click();
        System.out.println("job title clicked");
        Select job=new Select(driver.findElement(By.xpath("//select[@id='job_title_id']")));
        job.selectByVisibleText("QA Engineer");
        System.out.println("QA engg selected");

        //employment status
        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[4]/div/div[1]")).click();
        System.out.println("drop dowm emp status clicked");
        Select empstatus=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[4]/div/div[1]/select")));
        empstatus.selectByVisibleText("Full-Time Permanent");
        System.out.println("ft permnt selcted");

        //job category

        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[6]/div[1]/div[1]")).click();
        System.out.println("drop dowm job cat clicked");
        Select jobcat=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[6]/div[1]/div[1]/select")));
        jobcat.selectByVisibleText("Professionals");
        System.out.println("professionals selcted");

        //subunit

        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[8]/div[1]/div[1]")).click();
        System.out.println("drop dowm sub unit clicked");
        Select subunit=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[8]/div[1]/div[1]/select")));
        subunit.selectByVisibleText("QA Team");
        System.out.println("QA Team selcted");

        //shift type

        driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[10]/div[1]/div[1]")).click();
        System.out.println("drop dowm sub unit clicked");
        Select shifttype=new Select(driver.findElement(By.xpath("//oxd-decorator[@form='schemaForm.form[0]']/div[1]/div[10]/div[1]/div[1]/select")));
        shifttype.selectByVisibleText("General");
        System.out.println("General selcted");

        //region

        driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[1]/div[1]/div[1]")).click();
        System.out.println("drop dowm region clicked");
        Select regtype=new Select(driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[1]/div[1]/div[1]/select")));
        regtype.selectByVisibleText("Region-2");
        System.out.println(" Region-2 selcted");

        //FTE

        driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[2]/div[1]/div[1]")).click();
        System.out.println("drop dowm FTE clicked");
        Select ftetype=new Select(driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[2]/div[1]/div[1]/select")));
        ftetype.selectByVisibleText("0.75");
        System.out.println(" 0.75 selcted");

        //Temporary dept
        driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[3]/div[1]/div[1]")).click();
        System.out.println("drop dowm FTE clicked");
        Select tdepttype=new Select(driver.findElement(By.xpath("//form[@ng-if='customFieldsCtrl.isOxd']/oxd-decorator[1]/div[1]/div[3]/div[1]/div[1]/select")));
        tdepttype.selectByVisibleText("Sub unit-2");
        System.out.println(" Sub unit-2 selcted");

        //save
        driver.findElement(By.xpath("//button[@class='btn btn-secondary right']")).click();

        //LOGOUT
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();


















    }



}
