package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions,hooks")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:docs/index.html")
@ConfigurationParameter(key = "cucumber.monochrome", value = "true")
public class TestRunner {
}
