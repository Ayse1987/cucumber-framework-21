package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {
                    "html:target/default-cucumber-reports",
                    "json:target/json-report/cucumber.json",
                    "junit:target/xml-report/cucumber.xml",
                    "rerun:target/failedRerun.txt"
            },
            features = "./src/test/resources/features",
            glue = "stepdefinitions",
            tags = "@room_reservation_2 or @google_search",
            dryRun = false
    )
    public class TestRunner {
    }


