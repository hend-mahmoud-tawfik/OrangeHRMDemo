import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    WebDriver driver;

    String Browser;

    String Base_URL;

    @BeforeTest
    public void init() {
        driver = new EdgeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    /*@AfterTest
    public void tearDown(){
        driver.quit();
    }*/
}


