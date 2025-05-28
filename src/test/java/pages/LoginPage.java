package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("http://ptbsp.ddns.net:6882/login");
    }

    public void enterUsername(String username) {
        WebElement element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.clear();
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
