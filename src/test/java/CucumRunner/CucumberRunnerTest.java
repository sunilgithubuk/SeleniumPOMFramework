package CucumRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features = "src/test/resources/features/",
                glue = "SunWebOathE2E",
                tags = "@SunRegister33",
                plugin = {"pretty","html:target/cucumber-reports"})
public class CucumberRunnerTest {
}
