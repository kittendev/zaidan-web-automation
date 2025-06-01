package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Logout {

    private final WebDriver driver = new FirefoxDriver();
    WebDriverWait wait;

    public Logout() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("User is logged in with valid credentials")
    public void user_on_dashboard_page() {
        driver.get("http://ptbsp.ddns.net:6882/login");

        String username = "bendahara";
        String password = "admin123";

        WebElement element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys(username);

        element = driver.findElement(By.name("password"));
        element.clear();
        element.sendKeys(password);

        element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]")));
    }

    @When("User clicks on the logout button")
    public void user_clicks_logout_button() {
        By logoutIconLocator = By.xpath("//*[name()='svg' and contains(@class, 'lucide-log-out')]");

        WebElement svgIcon = wait.until(ExpectedConditions.presenceOfElementLocated(logoutIconLocator));

        Actions builder = new Actions(driver);
        builder.click(svgIcon).build().perform();
    }

    @And("User confirms logout")
    public void user_confirms_logout() {
        By confirmYesButtonLocator = By.xpath("//button[normalize-space(text())='Ya']");

        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(confirmYesButtonLocator));

        yesButton.click();
    }

    @Then("User should be redirected to the login page with {string} header")
    public void user_redirected_to_login_page(String headerText) {
        wait.until(ExpectedConditions.urlContains("login"));
        WebElement loginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'" + headerText + "')]")));
        assertNotNull(loginHeader, "Login header not found, logout might have failed.");
        driver.quit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
