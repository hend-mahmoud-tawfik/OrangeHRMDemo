import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SaveSystemUserPage;
import pages.ViewSystemUserPage;

public class AddUserTest extends BaseTest{

    String newUserName = "admin";

    String generatedUserName = newUserName + System.currentTimeMillis();

    @Test (description = "verify the successful adding user and confirm that the user is added successfully and displayed in the users list")
    @Description ("the successful adding for a new user")
    public void testAddUser(){
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        new ViewSystemUserPage(driver)
                .clickOnAddBtn();
        new SaveSystemUserPage(driver)
                .fillData(" James" , generatedUserName, "hmahmou1234@" )
                .clickOnSaveBtn();
        Assert.assertTrue(ViewSystemUserPage.confirmAddedUserIsDisplayed(generatedUserName));
    }

    @Test (description = "verify the successful editing for user and confirm that the user is edited successfully")
    @Description ("the successful editing for a user")
    public void editUser() {
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        new ViewSystemUserPage(driver)
                .clickOnEditBtn();
        WebElement editUserLabel = SaveSystemUserPage.getEditUserLabel(driver);
        boolean IsEditUserLabelDisplayed = editUserLabel.isDisplayed();
        Assert.assertTrue(IsEditUserLabelDisplayed);
    }

    @Test
    public void confirmUserNameIsChanged(){
        new LoginPage(driver)
                .login("Admin", "admin123");
        new DashboardPage(driver)
                .clickOnAdminLink();
        new ViewSystemUserPage(driver)
                .clickOnEditBtn();
        new SaveSystemUserPage(driver)
                .editUserName(generatedUserName);
        Assert.assertTrue(ViewSystemUserPage.confirmAddedUserIsDisplayed(generatedUserName));
    }

}
