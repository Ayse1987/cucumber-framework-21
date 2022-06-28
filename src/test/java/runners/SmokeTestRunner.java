package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports1",//we added 1 at the end of the name of report
                "json:target/json-report/cucumber.json1",
                "junit:target/xml-report/cucumber.xml1",
                "rerun:target/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)
public class SmokeTestRunner {
}
