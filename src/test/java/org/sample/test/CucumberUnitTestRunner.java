package org.sample.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/", glue = "org.sample.test.glue", strict = true, tags = "not @notImplemented")
public class CucumberUnitTestRunner extends BaseRunner {

}