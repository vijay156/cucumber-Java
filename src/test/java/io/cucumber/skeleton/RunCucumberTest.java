package io.cucumber.skeleton;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\io\\cucumber\\skeleton", glue = { "io.cucumber.stepDef" }, plugin = { "pretty" }
)
public class RunCucumberTest {
}
