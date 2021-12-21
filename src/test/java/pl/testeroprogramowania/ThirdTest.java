package pl.testeroprogramowania;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class ThirdTest {
   @Test(priority = 2)
    public void firstTest(){
       System.out.println("I am first test");

    }
    @Test(priority = 1)
    public void secondTest(){
        System.out.println("I am second test");
    }
    @Test(priority = 3)
    public void thirdTest(){
        System.out.println("I am third test");
    }
}
