package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //        html = TYPE OF THE REPORTS
//        target= REPORT FOLDER
//        default-cucumber-reports= REPORT NAME
        plugin = {
                "html:target/default-cucumber-reports",//sadece bu yeterli, digeleri cok anlasilir olmayan alternatifler
                "json:target/json-report/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "@target\\failedRerun.txt",
        glue = "stepdefinitions",
        tags = "@google_search",
        dryRun = false
)
public class FailedScenarioRunner {
}
