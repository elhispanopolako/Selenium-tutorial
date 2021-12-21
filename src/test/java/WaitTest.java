import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


public class WaitTest {
    WebDriver driver;

    @Test
    public void WaitTest()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000);
       // WebDriverWait wait=new WebDriverWait(driver,10);



        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        waitForElementToExist(By.cssSelector("p"));
        driver.findElement(By.cssSelector("p"));
    }
    public void waitForElementToExist(By locator){
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

      /*  wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<WebElement> element= driver.findElements(locator);
                if(element.size()>0){
                    System.out.println("Element jest widoczny na stronie");
                    return true;
                }else{
                    System.out.println("Element jest niewidoczny na stronie");
                    return false;
                }

            }
        })*/
        wait.until((driver)-> {

                List<WebElement> element= driver.findElements(locator);
                if(element.size()>0){
                    System.out.println("Element jest widoczny na stronie");
                    return true;
                }else{
                    System.out.println("Element jest niewidoczny na stronie");
                    return false;
                }


        });
    }

}