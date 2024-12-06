import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    WebDriver driver;

    /*@BeforeTest
    public void init() {
        driver = new EdgeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }*/

    @BeforeTest
    public void init() throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("src/test/resources/data.properties");
        properties.load(fileReader);
        String myBrowser = properties.getProperty("browser");
        if(myBrowser.equalsIgnoreCase("firefox"))
        {
            driver= new FirefoxDriver();
        } else if (myBrowser.equalsIgnoreCase("chrome")) {
            driver= new ChromeDriver();
        } else if (myBrowser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }
        else
        {
            throw new IllegalArgumentException("Invalid browser specified: " + myBrowser);
        }
        String myUrl = properties.getProperty("url");
        driver.manage().window().maximize();
        driver.get(myUrl);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}


