import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class Zad4Test {
    
    private final WebDriver webDriver;
    
    public Zad4Test(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
    }
    
    @BeforeEach
    public void goToPage() {
        webDriver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testPageLoadTimeout() {
        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.findElement(By.id("search_form_input_homepage"))
                .sendKeys("dfgdf");
        webDriver.findElement(By.id("search_button_homepage"))
                .click();
        
        assertTrue(webDriver.getTitle().contains("dfgdf"));
    }
    
    @Test
    public void testScriptLoadTimeout() {
        webDriver.manage()
                .timeouts()
                .setScriptTimeout(10, TimeUnit.SECONDS);
        webDriver.findElement(By.id("search_form_input_homepage"))
                .sendKeys("dfgdf");
        webDriver.findElement(By.id("search_button_homepage"))
                .click();
        
        assertTrue(webDriver.getTitle().contains("dfgdf"));
    }
    
}