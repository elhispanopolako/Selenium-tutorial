package pl.testeroprogramowania;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleTestLIstener implements ITestListener {
   @Override
    public void onTestStart(ITestResult iTestResult) {
       System.out.println("I am starting test listener");
    }

   @Override
    public void onTestFailure(ITestResult result) {
       System.out.println("I am taking screenshot");
    }

}

