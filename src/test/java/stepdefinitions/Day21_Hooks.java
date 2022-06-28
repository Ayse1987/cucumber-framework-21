package stepdefinitions;
//jUnit @ Before each @Test
//Cucumber @Before -> No need to extend it works for each scenatrio
// Hook should be in step def otherwise will not work


import io.cucumber.java.After;
import io.cucumber.java.Before;//import from cucumber
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ReusableMethods;

public class Day21_Hooks {
    /*
    Hooks will have @before and @after methods
   In our framework We use hooks to take screen shot of failed scenarios
     */
    //This will be read before and after each class
//    @Before
//    public void setUp(){
//        //System.out.println("This is @Before method");
//    }
//    @After
//    public void tearDown(Scenario scenario){
//        //System.out.println("This is @After method");
//        //This method will take screen shot when scenario fails
//        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        //attaching the screenshot to the reports if the scenario fails
//        if(scenario.isFailed()){
//            scenario.attach(screenshot,"image/png","ScreenShot");
//        }
//
//    }
}
