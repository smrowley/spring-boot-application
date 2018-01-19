package org.sample.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "", strict = true, tags = "not @notImplemented")
public class CucumberUnitTestRunner {

}
