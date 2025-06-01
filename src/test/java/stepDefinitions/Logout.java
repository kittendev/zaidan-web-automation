package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Logout {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User is logged in with valid credentials")
    public void user_on_dashboard_page() {
        driver.get("http://ptbsp.ddns.net:6882/login");

        WebElement element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys("bendahara");

        element = driver.findElement(By.name("password"));
        element.clear();
        element.sendKeys("admin123");

        element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]")));
    }

    @When("User clicks on the logout button")
    public void user_clicks_logout_button() {
        WebElement svgIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[name()='svg' and contains(@class, 'lucide-log-out')]")));
        new Actions(driver).click(svgIcon).perform();
    }

    @And("User confirms logout")
    public void user_confirms_logout() {
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Ya']")));
        yesButton.click();
    }

    @Then("User should be redirected to the login page with {string} header")
    public void user_redirected_to_login_page(String headerText) {
        wait.until(ExpectedConditions.urlContains("login"));
        WebElement loginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'" + headerText + "')]")));
        assertNotNull(loginHeader);
    }
}
