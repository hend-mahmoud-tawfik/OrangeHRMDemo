package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
     private Wait<WebDriver> wait;



    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
    protected void fluentWaitImplementation() {
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
    }
}
