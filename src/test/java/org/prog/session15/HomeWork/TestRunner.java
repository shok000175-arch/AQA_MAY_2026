package org.prog.session15.HomeWork;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
