import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginTests extends BaseTest {


    @Test
    public void testValidLogin() {
        new LoginPage(driver)
                .login("Admin", "admin123");
        WebElement dashboardMenu = DashboardPage.getDashboardMenu(driver);
        boolean dashboardMenuDisplayed = dashboardMenu.isDisplayed();
        Assert.assertTrue(dashboardMenuDisplayed);
    }


    @Test
    public void testInValidPw() {
        new LoginPage(driver)
                .login("Admin", "wrongpw");
        WebElement invalidMessage = LoginPage.getInvalidMessage(driver);
        boolean invalidMessageDisplayed = invalidMessage.isDisplayed();
        Assert.assertTrue(invalidMessageDisplayed);
    }


    @Test
    public void testInValidUserName() {
        new LoginPage(driver)
                .login("wronguser", "admin123");
        WebElement invalidMessage = LoginPage.getInvalidMessage(driver);
        boolean invalidMessageDisplayed = invalidMessage.isDisplayed();
        Assert.assertTrue(invalidMessageDisplayed);
    }

}
