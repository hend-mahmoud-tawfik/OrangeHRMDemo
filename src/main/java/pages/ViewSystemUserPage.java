package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewSystemUserPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public ViewSystemUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private By addBtn = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");

    private static By systemUserLabel =  By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']");

    public static WebElement getSystemUserLabel(WebDriver driver){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(systemUserLabel));
    }

    public SaveSystemUserPage clickOnAddBtn(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        driver.findElement(addBtn).click();
        return new SaveSystemUserPage(driver);
    }
}

