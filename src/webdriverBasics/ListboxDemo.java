package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ListboxDemo {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

        driver.manage().window().maximize();

        //To Switch into a frame
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched into iframe");


        WebElement element = driver.findElement(By.xpath("//select[@id='cars']"));
        Select s = new Select(element);
        s.selectByIndex(0);
        Thread.sleep(1000);
        s.selectByVisibleText("Audi");
        Thread.sleep(1000);
        s.selectByValue("opel");
        System.out.println("Multiple values are selected from a drop-down");

        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        //System.out.println("Clicked on Submit button");
        Thread.sleep(1000);

        /*s.deselectByIndex(3);
        System.out.println("deselecting the 3rd indexed value");
        Thread.sleep(1000);
        s.deselectByValue("volvo");
        System.out.println("deselecting the volvo from a list-box");
        Thread.sleep(1000);
        s.deselectByVisibleText("Opel");*/

       // s.deselectAll();
       // System.out.println("Deselected all the values from a drop-down");

        boolean b=s.isMultiple();
        if(b){
            System.out.println("multiselected drop-down");
        }else{
            System.out.println("not a multiselected drop-down");
        }

        WebElement element_firstOption=s.getFirstSelectedOption();
        System.out.println("first selected option is :"+element_firstOption.getText());

        System.out.println("********** All Selected Options ********");
        List<WebElement> selectedOptions=s.getAllSelectedOptions();
        for(WebElement element_option:selectedOptions){
            String text=element_option.getText();
            System.out.println(text+" is selected");
        }



        driver.switchTo().defaultContent();
        driver.findElement(By.id("getwebsitebtn")).click();
    }
}
