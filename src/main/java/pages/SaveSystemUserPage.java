package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SaveSystemUserPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public SaveSystemUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static By addUserTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    private By userRoleDropMenu = By.xpath("//label[contains(., 'User Role')]//following::div[1]//div[@class='oxd-select-text-input']\n");

    private By statusDropMenu = By.xpath("//label[contains(., 'Status')]//following::div[1]//div[@class='oxd-select-text-input']");

    private By enabeledOpion = By.xpath("//span[text()='Enabled']");
    private By saveBtn = By.cssSelector("button[type=submit]");

    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    private By userNameField = By.xpath("//label[contains(., 'Username')]//following::div[1]//input[@class='oxd-input oxd-input--active']");

    private By pwField = By.xpath("//label[('Password')]//following::div[4]//input[@class='oxd-input oxd-input--active']");

    private By confirmPwField = By.xpath("//label[contains(., 'Confirm Password')]//following::div[1]//input[@class='oxd-input oxd-input--active']");

    private By pwText = By.cssSelector(".oxd-text.oxd-text--p.user-password-hint");

    private static By editUserLabel = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");

    private By essOption = By.xpath("//span[text()='ESS']");

    private By requiredBtn = By.xpath("//span[text()='Required']");

    private By nameSelected = By.xpath("//span[text()='Paul Lewis Amiano']");

    protected Actions actions;

    protected JavascriptExecutor js;

    public static WebElement getAddUserTitle(WebDriver driver) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addUserTitle));
    }


    public SaveSystemUserPage fillData(String employeeName, String userName, String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pwText));
        driver.findElement(userRoleDropMenu).click();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(essOption));
        driver.findElement(essOption).click();
        driver.findElement(employeeNameInput).sendKeys(employeeName);
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(nameSelected));
        driver.findElement(nameSelected).click();
        driver.findElement(statusDropMenu).click();
        driver.findElement(enabeledOpion).click();
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(pwField).sendKeys(password);
        driver.findElement(confirmPwField).sendKeys(password);
        return this;
    }

    public ViewSystemUserPage clickOnSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();
        return new ViewSystemUserPage(driver);
    }

    public static WebElement getEditUserLabel(WebDriver driver) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(editUserLabel));
    }


    public void clearUserName() {
        driver.findElement(userNameField).clear();
    }


    public void clearText(String editedUser) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//label[contains(., 'Username')]//following::div[1]//input[@class='oxd-input oxd-input--active']")
        )).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        driver.findElement(saveBtn).click();

    }

    public void setUserName(String editedUser) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(editedUser);
    }

    public ViewSystemUserPage editUserName(String editedUser) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        clearText(editedUser);
        setUserName(editedUser);
        driver.findElement(saveBtn).click();
        return new ViewSystemUserPage(driver);
    }
}

