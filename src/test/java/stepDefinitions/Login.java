package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class Login {

    private final WebDriver driver = new FirefoxDriver();
    WebDriverWait wait;

    public Login() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

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

    @And("User press teh login button")
    public void user_clicks_login_button() {
        WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();
    }


    @Then("User is navigated to the dashboard page")
    public void user_should_be_redirected_to_dashboard(){
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]")));
        assertNotNull(dashboardHeader, "Dashboard header not found, login might have failed.");
        driver.quit();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}

