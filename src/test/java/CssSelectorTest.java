import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorTest {
    @Test
    public void findelement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssID=By.cssSelector("#clickOnMe");
        driver.findElement(cssID);

        By cssClass=By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag=By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Weryfikacja");

        By cssName=By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By all=By.cssSelector("*");
        driver.findElement(all);

        By ulInside=By.cssSelector("div ul");
       driver.findElement(ulInside);

       By trInTable=By.cssSelector("table tr");
       driver.findElement(trInTable);

       By trInbody=By.cssSelector("tbody tr");
       driver.findElement(trInbody);

       By firstChildUlinDiv=By.cssSelector("div>ul");
       driver.findElement(firstChildUlinDiv);
       By firstChildTable=By.cssSelector("tbody> tr");
       driver.findElement(firstChildTable);

       By firstFormAfterLabel=By.cssSelector("label + form");
       By AllFormsAfterLabel=By.cssSelector("label~ form");
       driver.findElement(firstFormAfterLabel);
       driver.findElement(AllFormsAfterLabel);

       By firstChild=By.cssSelector("li:first-child");
        By lastChild=By.cssSelector("li:last-child");
        By thirdChild=By.cssSelector("li:nth-child(3)");
         driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);

    }
}
