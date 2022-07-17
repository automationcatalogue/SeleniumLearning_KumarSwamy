package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bseindia.com/markets/currencyDerivatives/most_active.html?flagseries=&flagcall=&flagstrgid=&FlagDrop=");
        driver.manage().window().maximize();

        List<WebElement> rowelements=driver.findElements(By.xpath("//div[@class='largetable']/table/tbody/tr/td/table/tbody[2]/tr"));
        System.out.println("Total number of rows are "+rowelements.size());

        List<WebElement> colElements=driver.findElements(By.xpath("//div[@class='largetable']/table/tbody/tr/td/table/tbody[2]/tr[1]/td"));
        System.out.println("Total number of columns are :"+colElements.size());

        //To print the table data [legacy/traditional]
        /*for(int i=1;i<=rowelements.size();i++){
            for(int j=1;j<= colElements.size();j++){
                String data=driver.findElement(By.xpath("//div[@class='largetable']/table/tbody/tr/td/table/tbody[2]/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(data+" ");
            }
            System.out.println();
        }*/

        //To print the table data using Enhanced for loop
        for(WebElement rowData:rowelements){
            List<WebElement> colmnsData=rowData.findElements(By.tagName("td"));
            for(WebElement colData:colmnsData){
                String data=colData.getText();
                System.out.println(data+" ");
            }
            System.out.println();
        }
    }
}
