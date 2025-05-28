package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Login {

    private final WebDriver driver = Hooks.driver;
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("User type {string} in the username field")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("User type {string} in the password field")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("User press the login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User is navigated to the dashboard page")
    public void user_successful_login() {
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]")));
        assertNotNull(dashboardHeader, "Dashboard header not found, login might have failed.");
    }

    @Then("User should be able to see {string} notification message")
    public void user_unsuccessful_login(String expectedMessage) {
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + expectedMessage + "')]")));
        assertNotNull(alert, "Notification message not found");
    }
}

