import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class Zad2Test {
    
    private final WebDriver webDriver;
    
    public Zad2Test(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
    }
    
    @BeforeEach
    public void goToPage() {
        webDriver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testById() {
        assertTrue(isElementPresent(By.id("search_button_homepage")));
    }
    
    @Test
    public void testNotExistingById() {
        assertFalse(isElementPresent(By.id("asdfsfdgdfg")));
    }
    
    private boolean isElementPresent(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }
    
}
