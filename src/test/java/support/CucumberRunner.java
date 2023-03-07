package support;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports" }, features = { "src/test/features" }, glue = {
		"steps/" }, tags = { "~@notImplemented" })
public class CucumberRunner {
}


//if you want run  all scenarios add tag in glue: ~@notImplemented
//else you can use specific tag describes in feature