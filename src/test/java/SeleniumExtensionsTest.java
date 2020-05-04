import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class SeleniumExtensionsTest {
    private final WebDriver webDriver;
    
    public SeleniumExtensionsTest(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
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
    
}
