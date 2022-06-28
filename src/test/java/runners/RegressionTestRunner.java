package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports2",
                "json:target/json-report/cucumber.json2",
                "junit:target/xml-report/cucumber.xml2",
                "rerun:target/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@regression",
        dryRun = false
)
public class RegressionTestRunner {
}
