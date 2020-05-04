import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverManagerTest {
    
    private static WebDriver webDriver;
    
    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver()
                .setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @BeforeEach
    public void goToPage() {
        webDriver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testTitlePage() {
        assertEquals("DuckDuckGo — Privacy, simplified.", webDriver.getTitle());
    }
    
    @Test
    public void testSource() {
        String source = webDriver.getPageSource();
        assertTrue(source.contains("DuckDuckGo"));
    }
    
    @Test
    public void testClick() {
        webDriver.findElement(By.id("search_form_input_homepage"))
                .sendKeys("Mateusz Miotk");
        webDriver.findElement(By.id("search_button_homepage"))
                .click();
        assertEquals("Mateusz Miotk at DuckDuckGo", webDriver.getTitle());
    }
    
    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
    
}