package webdriverBasics;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class DatePickerDemo {
    public static void main(String[] args) throws Exception{



        Properties prop = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
        prop.load(fis1);

        String data = prop.getProperty("browser");
        System.out.println(data);

        String projectPath=System.getProperty("user.dir");
        System.out.println("projectPath :"+projectPath);

        FileInputStream fis = new FileInputStream(projectPath+"\\TestData\\AutomationCatalogue.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh=wbk.getSheet("AddEmployee");

        String dob="9-June-1986";

        String chromeDriverPath=prop.getProperty("chromeDriverExePath");
        System.out.println(chromeDriverPath);

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        String url=prop.getProperty("orangeHRMURL");
        System.out.println(url);

        driver.get(url);
        driver.manage().window().maximize();

        //username
        String userName=sh.getRow(1).getCell(3).getStringCellValue();
        System.out.println("UserName from Excel sheet is :"+userName);
        driver.findElement(By.name("txtUsername")).sendKeys(userName);

        //password
        String password=sh.getRow(1).getCell(4).getStringCellValue();
        System.out.println("Password from Excel sheet is :"+password);
        driver.findElement(By.id("txtPassword")).sendKeys(password);

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
        String firstName=sh.getRow(1).getCell(5).getStringCellValue();
        System.out.println("FirstName from Excel sheet is :"+firstName);
        driver.findElement(By.cssSelector("#first-name-box")).sendKeys(firstName);

        System.out.println("Firstname is entered");

        //LastName
        String lastName=sh.getRow(1).getCell(6).getStringCellValue();
        System.out.println("LastName from Excel sheet is :"+lastName);
        driver.findElement(By.cssSelector("#last-name-box")).sendKeys(lastName);
        System.out.println("Lastname is entered");

        //Location
        String location = sh.getRow(1).getCell(7).getStringCellValue();
        driver.findElement(By.cssSelector(".btn.dropdown-toggle")).click();
        System.out.println("Location is clicked");
        driver.findElement(By.xpath("//span[text()='"+location+"']")).click();
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
        List<WebElement> elements_year=driver.findElements(By.xpath("//input[@id='emp_birthday']//following-sibling::span[1]//div//ul[@class='dropdown-content select-dropdown active']/li/span"));
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

        String employeeID="0176";
        FileOutputStream fos = new FileOutputStream(projectPath+"\\TestData\\AutomationCatalogue.xlsx");
        XSSFRow row=sh.getRow(1);
        XSSFCell cell=row.getCell(11);

        if(cell==null){
            row.createCell(11);
            cell.setCellValue(employeeID);
        }else{
            cell.setCellValue(employeeID);
        }

        wbk.write(fos);
        fos.close();
        fis.close();
        System.out.println("employeeID is written back to Excel sheet");

    }
}
