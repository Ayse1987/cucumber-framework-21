package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day22_Selenium_Grid_Step_Defs {

    WebDriver driver;

    @Given("user is on the application_login page with chrome")
    public void user_is_on_the_application_login_page_with_chrome() throws MalformedURLException {

//       1. Create Desired Capabilities object
        DesiredCapabilities cap=new DesiredCapabilities();

//       2. Use cap ro assign browser name and operation system
        cap.setBrowserName("chrome");
//        cap.setPlatform(Platform.MAC); //For mac
//        cap.setPlatform(Platform.WINDOWS); //for windows
        cap.setPlatform(Platform.ANY); // for either mac or windows

//       3. Merge the Chrome with Desired Capabilities
        ChromeOptions options=new ChromeOptions();
        options.merge(cap);

//       4. Create driver object using RemoteWebDriver
//         Hub URL = porturl / wd / hub
        String hubURL="http://192.168.8.104:4444/wd/hub";
        driver= new RemoteWebDriver(new URL(hubURL),options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        5. CONFIGURATIONS ARE DONE. WE CAN WRITE OUR JAVA CODES
        driver.get(ConfigReader.getProperty("google_url"));
    }
    @Then("verify the tile includes Resortsline")
    public void verify_the_tile_includes_resortsline() {
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Google"));
    }

    @Given("user is on the application_login page with firefox")
    public void user_is_on_the_application_login_page_with_firefox() throws MalformedURLException {
        //       1. Create Desired Capabilities object
        DesiredCapabilities cap=new DesiredCapabilities();

        //       2. Use cap ro assign browser name and operation system
        cap.setBrowserName("firefox");//DIFFERENT THAN CHROME
//        cap.setPlatform(Platform.MAC); //For mac
//        cap.setPlatform(Platform.WINDOWS); //for windows
        cap.setPlatform(Platform.ANY); // for either mac or windows

        //       3. Merge the Chrome with Desired Capabilities
        FirefoxOptions options=new FirefoxOptions();//DIFFERENT THAN CHROME
        options.merge(cap);
        //       4. Create driver object using RemoteWebDriver
//         Hub URL = porturl / wd / hub
        String hubURL="http://192.168.8.104:4445/wd/hub";
        driver= new RemoteWebDriver(new URL(hubURL),options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        ReusableMethods.waitFor(5);
        //        5. CONFIGURATIONS ARE DONE. WE CAN WRITE OUR JAVA CODES
        driver.get(ConfigReader.getProperty("google_url"));

    }


}
