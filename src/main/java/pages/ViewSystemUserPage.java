package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewSystemUserPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public ViewSystemUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    private By addBtn = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");

    private static By systemUserLabel =  By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']");

    private By userRoleField = By.xpath("//label[contains(., 'User Role')]//following::div[2]//div[@class='oxd-select-text-input']");

    private By searchBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    private By adminUserRole = By.xpath("//div[text()='User Role']");

    public static WebElement getSystemUserLabel(WebDriver driver){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(systemUserLabel));
    }

    public SaveSystemUserPage clickOnAddBtn(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        driver.findElement(addBtn).click();
        return new SaveSystemUserPage(driver);
    }
    public void searchAboutUserRole(){
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)) ;
        driver.findElement(userRoleField).click();
        driver.findElement(userRoleField).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        driver.findElement(searchBtn).click();
    }


}

