package org.sample.integrationtest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.sample.integrationtest.util.Props;
import org.sample.test.BaseRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:featuresInt/", glue = {"org.sample.test.glue", "org.sample.integrationtest.glue"}, strict = false, tags = "not @notImplemented")
public class IntegrationTestRunner extends BaseRunner {

	@BeforeClass
	public static void initialize() {
		Props.init();
	}
}
