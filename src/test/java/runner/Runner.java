package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
glue={"StepDefinitions"},
monochrome=true,
plugin={"pretty", 
		"junit:target/JunitReports/relatorio.xml",
		"json:target/JSONReports/relatorio.json",
		"html:target/Html"}
		)

public class Runner {

}
