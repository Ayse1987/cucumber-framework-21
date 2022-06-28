package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports3",
                "json:target/json-report/cucumber3.json",
                "junit:target/xml-report/cucumber3.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "./src/test/resources/features/db_features",
        glue = "database_stepdefinitions",
        tags = "@db_create",
        dryRun = false
)
//This class is only used for running database related tests
public class DBRunner {

}
