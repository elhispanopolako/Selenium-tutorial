import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
       driver.manage().window().maximize(); //robi przeglądarke na caly ekran
       // Dimension windowSize= new Dimension(200,200);//zarządza oknem na ustawione parametry
       // driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.com/");
        //driver.quit();
        //driver.close();
         //przechodzimy pliki cookie
        driver.switchTo().frame(0);
        //znalezienie i klikniecie przycisku
       WebElement agreeButton= driver.findElement(By.xpath("//span[contains(text(),'Zgadzam')]"));
       agreeButton.click();
       //powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        //Znalezienie pola wyszukiwania i wyszukania frazy
        WebElement searchField= driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        WebElement result= driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//span"));
        Assert.assertTrue(result.isDisplayed());
    }
    public WebDriver getDriver(String browser){
        switch (browser){
            case "chrome":
               // String chromePath="C:\\Users\\Toshiba\\Downloads\\chromedriver_win32\\chromedriver.exe";
                //System.setProperty("webdriver.chrome.driver",chromePath);
                return new ChromeDriver();
            case "firefox":
                String firefoxPath="C:\\Users\\Toshiba\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver",firefoxPath);
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }

}
