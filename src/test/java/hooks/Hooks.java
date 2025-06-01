package hooks;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import utils.DriverManager;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest scenarioTest;

    @BeforeAll
    public static void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("build/reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.fail("Scenario Failed ❌");
        } else {
            scenarioTest.pass("Scenario Passed ✅");
        }
        DriverManager.quitDriver();
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
    }
}
