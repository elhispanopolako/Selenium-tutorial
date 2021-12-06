import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonId= By.id("clickOnMe");//przez ID
       WebElement clickOnMeButton= driver.findElement(buttonId);

       WebElement firstNameButton=driver.findElement(By.name("fname"));//przez atrybut name

       WebElement paraHidden=driver.findElement(By.className("topSecret"));//przez atrybut classname

        WebElement inPut= driver.findElement(By.tagName("input"));
        inPut.sendKeys("Pierwszy");
        List<WebElement> inPuts=driver.findElements(By.tagName("input"));
        System.out.println(inPuts.size());

    }
}
