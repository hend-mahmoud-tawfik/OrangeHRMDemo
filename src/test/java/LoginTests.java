import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    @Test (description = "verify the successful login with valid user and password")
    @Description ("the successful login testCase")
    public void testValidLogin() {
        new LoginPage(driver)
                .login("Admin", "admin123");
        WebElement dashboardMenu = DashboardPage.getDashboardMenu(driver);
        boolean dashboardMenuDisplayed = dashboardMenu.isDisplayed();
        Assert.assertTrue(dashboardMenuDisplayed);
    }
    @Test (description = "verify the unsuccessful login with invalid password")
    @Description ("the unsuccessful login")
    public void testInValidPw() {
        new LoginPage(driver)
                .login("Admin", "wrongpw");
        WebElement invalidMessage = LoginPage.getInvalidMessage(driver);
        boolean invalidMessageDisplayed = invalidMessage.isDisplayed();
        Assert.assertTrue(invalidMessageDisplayed);
    }


    @Test (description = "verify the unsuccessful login with invalid username")
    @Description ("the unsuccessful login")
    public void testInValidUserName() {
        new LoginPage(driver)
                .login("wronguser", "admin123");
        WebElement invalidMessage = LoginPage.getInvalidMessage(driver);
        boolean invalidMessageDisplayed = invalidMessage.isDisplayed();
        Assert.assertTrue(invalidMessageDisplayed);
    }

}
