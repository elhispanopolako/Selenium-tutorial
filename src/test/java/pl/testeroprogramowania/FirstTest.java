package pl.testeroprogramowania;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
@Listeners(value = SampleTestLIstener.class)

public class FirstTest extends BaseTest {
    WebDriver driver;

    @Test
        public void FirstTest()  {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
            driver.findElement(By.id("clickOnMe")).click();




            FluentWait<WebDriver> wait=new FluentWait<>(driver);
            wait.ignoring(NoSuchElementException.class);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofSeconds(1));

            waitForElementToExist(By.cssSelector("p"));
            driver.findElement(By.cssSelector("p"));
            WebElement para=driver.findElement(By.cssSelector("p"));
            Assert.assertEquals(para.isDisplayed(),true);
            Assert.assertTrue(para.isDisplayed());
            Assert.assertTrue(para.getText().startsWith("Dopiero"));
            Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
            Assert.assertEquals(para.getText(),"Dopiero się pojawiłem!");
            //Assert.assertEquals(para.getText(),"Dopiero","Tekst jest różny");
            driver.quit();
        }

        public void waitForElementToExist(By locator){
            FluentWait<WebDriver> wait=new FluentWait<>(driver);
            wait.ignoring(NoSuchElementException.class);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofSeconds(1));

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
    @Test @Ignore
    public void SecondTest()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        SoftAssert softAssert=new SoftAssert();


        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        waitForElementToExist(By.cssSelector("p"));
        driver.findElement(By.cssSelector("p"));
        WebElement para= driver.findElement(By.cssSelector("p"));
        softAssert.assertEquals(para.isDisplayed(),true);
        softAssert.assertTrue(para.isDisplayed());
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(para.getText(),"Dopiero się pojawiłem!","druga asercia");

        driver.quit();
        softAssert.assertAll();
    }}