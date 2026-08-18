package org.prog.session15.HomeWork;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/MyCucumberWebTest.feature",
        glue = "org.prog.session15.HomeWork",
        plugin = "pretty"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
