package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private By userNameField = By.name("username");
    private By passwordField = By.name("password");

    private By loginBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    private static By invalidMessage = By.xpath("//div[@class='oxd-alert oxd-alert--error']");
    public DashboardPage login(String userName , String passWord){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(passWord);
        driver.findElement(loginBtn).click();
        return new DashboardPage(driver);
    }

    public static WebElement getInvalidMessage(WebDriver driver){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidMessage));

    }

}

