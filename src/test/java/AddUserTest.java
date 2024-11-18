import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SaveSystemUserPage;
import pages.ViewSystemUserPage;

public class AddUserTest extends BaseTest{

    @Test
    public void testAddUser(){
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        new ViewSystemUserPage(driver)
                .clickOnAddBtn();
        new SaveSystemUserPage(driver)
                .fillData("hibrahim@", "hmahmou1234@")
                .clickOnSaveBtn();
    }
}
