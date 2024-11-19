import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SaveSystemUserPage;
import pages.ViewSystemUserPage;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigateToViewSystemUserPage() {
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        WebElement systemUserLabel = ViewSystemUserPage.getSystemUserLabel(driver);
        boolean systemUserLabelIsDisplayed = systemUserLabel.isDisplayed();
        Assert.assertTrue(systemUserLabelIsDisplayed);
    }

    @Test
    public void testNavigationToSaveSystemPage() {
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        new ViewSystemUserPage(driver)
                .clickOnAddBtn();
        WebElement addUserTitle = SaveSystemUserPage.getAddUserTitle(driver);
        boolean addUserTitleIsDisplayed = addUserTitle.isDisplayed();
        Assert.assertTrue(addUserTitleIsDisplayed);
    }
}
