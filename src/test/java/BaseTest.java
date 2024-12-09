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

    private Properties properties;
    private FileReader fileReader;

    /*@BeforeTest
    public void init() {
        driver = new EdgeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }*/



    @BeforeTest
    public void init() throws IOException {
        openBrowser();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));

    }

     public void openBrowser() throws IOException {
        properties = new Properties();
        fileReader = new FileReader("src/test/resources/data.properties");
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

     }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}


