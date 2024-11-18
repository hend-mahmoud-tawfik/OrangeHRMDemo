package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static By dashboardMenu = By.xpath("//ul[@class='oxd-main-menu']");

    private static By adminLink = By.xpath("//*[contains (@href , 'admin/viewAdminModule')]");

    public static WebElement getDashboardMenu(WebDriver driver) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardMenu));
    }

    public static WebElement getAdminLink(WebDriver driver) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adminLink));
    }
    public ViewSystemUserPage clickOnAdminLink(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(adminLink));
        driver.findElement(adminLink).click();
        return new ViewSystemUserPage(driver);
    }
}