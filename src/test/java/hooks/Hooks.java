package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import pages.LoginPage;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        new LoginPage(driver).openLoginPage();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}