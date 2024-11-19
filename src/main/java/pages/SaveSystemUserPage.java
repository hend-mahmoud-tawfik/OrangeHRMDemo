package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaveSystemUserPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public SaveSystemUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private static By addUserTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    private  By userRoleDropMenu = By.xpath("//label[contains(., 'User Role')]//following::div[1]//div[@class='oxd-select-text-input']\n");

    private  By statusDropMenu = By.xpath("//label[contains(., 'Status')]//following::div[1]//div[@class='oxd-select-text-input']");


    private By saveBtn = By.cssSelector("button[type=submit]");

    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    private static By searchBox = By.cssSelector("div.oxd-autocomplete-dropdown.--positon-bottom[role=\"listbox\"]");

    private By userNameField = By.xpath("//label[contains(., 'Username')]//following::div[1]//input[@class='oxd-input oxd-input--active']");

    //private By userRoleInput = By.xpath("//div([@class='oxd-select-text-input'])[1]//*[text()='Admin']");

    private By userRoleInput = By.xpath("//div([@class='oxd-select-text-input'])[1]//*[contains(text()='Admin']");

    private By pwField = By.xpath("//label[('Password')]//following::div[4]//input[@class='oxd-input oxd-input--active']");

    private By confirmPwField = By.xpath("//label[contains(., 'Confirm Password')]//following::div[1]//input[@class='oxd-input oxd-input--active']");

    private By pwText = By.cssSelector(".oxd-text.oxd-text--p.user-password-hint");

    String displayedName = "FN";
    public static WebElement getAddUserTitle(WebDriver driver){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addUserTitle));
    }

    public SaveSystemUserPage fillData(String employeName , String userName , String password ) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pwText));;
        driver.findElement(userRoleDropMenu).click();
       driver.findElement(userRoleDropMenu).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        driver.findElement(employeeNameInput).sendKeys(employeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(employeeNameInput).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

        /*driver.findElement(statusDropMenu).click();
        driver.findElement(statusDropMenu).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(pwField).sendKeys(password);
        driver.findElement(confirmPwField).sendKeys(password);*/
        return this;
    }

    public ViewSystemUserPage clickOnSaveBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();
        return new ViewSystemUserPage(driver);

    }
}
