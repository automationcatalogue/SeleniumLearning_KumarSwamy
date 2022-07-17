package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemo {
    public static void main(String[] args) throws Exception{
        String s1="Music";

        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();
        WebElement element_dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox' and @title='Search in']"));

        Select ob1 = new Select(element_dropdown);
        ob1.selectByIndex(10);
        System.out.println("10th Indexed drop-down is selected");

        Thread.sleep(3000);

        ob1.selectByValue("search-alias=electronics");
        System.out.println("Electronics value is selected from drop-down");

        Thread.sleep(3000);

        ob1.selectByVisibleText("Gift Cards");
        System.out.println("GiftCards is selected from drop-down");

        WebElement element_firstOption=ob1.getFirstSelectedOption();
        System.out.println("first selected option is :"+element_firstOption.getText());

        boolean b=ob1.isMultiple();
        if(b){
            System.out.println("multiselected drop-down");
        }else{
            System.out.println("not a multiselected drop-down");
        }
        System.out.println("********** All Available options in a drop-down **********");
        List<WebElement> allOptions=ob1.getOptions();
        for(WebElement element_option:allOptions){
            String text=element_option.getText();
            System.out.println(text);
        }
    }
}
