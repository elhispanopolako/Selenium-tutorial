import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPage= driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPage.getText());
        basicPage.click();
        String currentWindow= driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames= driver.getWindowHandles();
        for (String window:windowNames){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Tadek");
    }
}
