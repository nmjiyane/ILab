package apiRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Path to feature files
        glue = "stepDefinitions", // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {


}
