import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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
        System.out.println(basicPage.getText());
        basicPage.click();
        driver.findElement(By.id("fname")).sendKeys("Tadek");//Wysyłka danych textowych
        WebElement usernameInput=driver.findElement(By.name("username"));
        usernameInput.clear();//czyszczenie zawartości
        usernameInput.sendKeys("admin");
        System.out.println(usernameInput.getText());
        System.out.println(usernameInput.getAttribute("value"));//pobieranie z pola textowego
        usernameInput.sendKeys(Keys.ENTER);
        Alert firstalert=driver.switchTo().alert();
        firstalert.accept();
        driver.switchTo().alert().accept();




        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement selectCar= driver.findElement(By.cssSelector("select"));
        Select cars=new Select(selectCar);
        cars.selectByValue("saab");

        List<WebElement> options= cars.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }

        SelectCheck check=new SelectCheck();
        System.out.println(check.checkOption("Audi",selectCar));
        System.out.println(check.checkOption("Jeep",selectCar));
        WebElement para=driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: "+para.getText());
        System.out.println("By Atribute value: "+para.getAttribute("value"));
        System.out.println("By atribute text content: "+para.getAttribute("textContent"));//Dla ukrytych paragrafów






    }
}
