import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void iFrameTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe= driver.findElement(By.cssSelector("[src='basics.html']"));
        //driver.switchTo().frame(0);
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("fname")).sendKeys("Tadek");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }
}
