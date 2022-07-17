package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\AutomationCatalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/students/actions");
        driver.manage().window().maximize();

        WebElement element_draggable=driver.findElement(By.id("draggable"));
        WebElement element_droppable=driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
       // action.clickAndHold(element_draggable).release(element_droppable).build().perform();
        //action.dragAndDrop(element_draggable, element_droppable).build().perform();
        action.dragAndDropBy(element_draggable,50,100).build().perform();

        WebElement element_seven=driver.findElement(By.name("seven"));
        WebElement element_four=driver.findElement(By.name("four"));
        WebElement element_tweleve=driver.findElement(By.name("twelve"));
        WebElement element_eight=driver.findElement(By.name("eight"));

        action.keyDown(element_seven, Keys.CONTROL);
        action.click(element_four);
        action.click(element_tweleve);
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        System.out.println("Keyup and Keydown actions are performed");

        Thread.sleep(3000);
        action.click(element_eight).build().perform();


        WebElement element_dbBtn=driver.findElement(By.name("dblClick"));
        action.doubleClick(element_dbBtn).build().perform();

    }
}
