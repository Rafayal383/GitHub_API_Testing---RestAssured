package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/github_feature"},
glue = "stepDefination",
plugin = {"html:test-output/sanjay.html","json:test-output/sanjay.json"}
)
public class TestRunner {
	
}
