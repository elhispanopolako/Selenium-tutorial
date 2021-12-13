import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {
    @Test
    public void uploadTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
       /* File beforeUpload=screenshot.getScreenshotAs(OutputType.FILE);
       int randomNumber=(int)(Math.random()*1000);
        String fileName= "beforeUpload"+ randomNumber+".png";
        FileUtils.copyFile(beforeUpload,new File("src/test/resources/"+fileName));*/
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Toshiba\\Downloads\\CVenglish.pdf");
        Actions actions=new Actions(driver);
        //actions.contextClick().perform();//klikanie prawym przyciskiem myszy
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("src/test/resources/screenshot.png"));

    }
}
