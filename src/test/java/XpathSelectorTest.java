import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathSelectorTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonId= By.xpath("//button[@id='clickOnMe']");//przez ID
       WebElement clickOnMeButton= driver.findElement(buttonId);

       WebElement firstNameButton=driver.findElement(By.xpath("//input[@name='fname']"));//przez atrybut name

       WebElement paraHidden=driver.findElement(By.xpath("//p[@class='topSecret']"));//przez atrybut classname

        WebElement inPut= driver.findElement(By.xpath("//input"));
        inPut.sendKeys("Pierwszy");
        List<WebElement> inPuts=driver.findElements(By.tagName("input"));
        System.out.println(inPuts.size());
        By linktekst=By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolink=driver.findElement(linktekst);
        By partiallink=By.xpath("//a[contains(text(),'Visit')]");
        WebElement partialink= driver.findElement(partiallink);

        By fullPath= By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);
        By sortPath=By.xpath("//ul");
        driver.findElement(sortPath);

        By allXp=By.xpath("//*");
        driver.findElement(allXp);
        By secondElement=By.xpath("(//input)[2]");
        driver.findElement(secondElement);
        By lastElement=By.xpath("(//input)[last()]");
        driver.findElement(lastElement);
        By atribElement=By.xpath("//*[@name]");
        driver.findElement(atribElement);
        By atribEquals=By.xpath("//button[@id='clickOnMe']");
        driver.findElement(atribEquals);
        By atribNotEquals=By.xpath("//button[@id!='clickOnMe']");
        driver.findElement(atribNotEquals);
        By atrContain=By.xpath("//*[contains(@name,'ame')]");
        driver.findElement(atrContain);
        By startWith=By.xpath("//*[starts-with(@name,'user')]");
        driver.findElement(startWith);
        By endWith=By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']");
        driver.findElement(endWith);


        By child=By.xpath("//div/child::ul");
        By desc=By.xpath("//div/descendant::ul");
        By asc=By.xpath("//div/ancestor::*");
        By foll=By.xpath("//img/following::*");
        By follsib=By.xpath("//img/following-sibling::*");
        By przec=By.xpath("//img/preceding::*");
        By przecSib=By.xpath("//img/preceding-sibling::*");
        By parent=By.xpath("//div/../..");
        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follsib);
        driver.findElement(przec);
        driver.findElement(przecSib);
        driver.findElement(parent);

        By divAndLinks=By.xpath("//a | //div");
        By andOp=By.xpath("//input[@name='fname' and @id='fname']");
        By otOp=By.xpath("//input[@name='fname' or @id='fnam']");
        driver.findElement(divAndLinks);
        driver.findElement(andOp);
        driver.findElement(otOp);






        driver.quit();

    }
}
