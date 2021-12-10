import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActions {
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPage= driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPage.click();
        driver.findElement(By.id("fname")).sendKeys("Tadek");//Wysyłka danych textowych
        WebElement usernameInput=driver.findElement(By.name("username"));
        usernameInput.clear();//czyszczenie zawartości
        usernameInput.sendKeys("admin");
        usernameInput.sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement selectCar= driver.findElement(By.cssSelector("select"));
        Select cars=new Select(selectCar);
        cars.selectByValue("saab");

        List<WebElement> options= cars.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }


    }
}
