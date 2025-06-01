package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Login {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User has navigated on the login page")
    public void user_on_the_login_page() {
        driver.get("http://ptbsp.ddns.net:6882/login");
    }

    @When("User type {string} in the username field")
    public void user_enters_username(String username) {
        WebElement element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys(username);
    }

    @And("User type {string} in the password field")
    public void user_enters_password(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.clear();
        element.sendKeys(password);
    }

    @And("User press the login button")
    public void user_clicks_login_button() {
        WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();
    }

    @Then("User is navigated to the dashboard page")
    public void user_successful_login(){
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]")));
        assertNotNull(dashboardHeader, "Dashboard header not found, login might have failed.");
    }

    @Then("User should be able to see {string} notification message")
    public void user_unsuccessful_login(String expectedMessage) {
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + expectedMessage + "')]")));
        assertNotNull(alert, "Notification message not found");
    }
}
