import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class Zad3Test {
    
    private final WebDriver webDriver;
    
    public Zad3Test(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
    }
    
    @Test
    public void testElementToBeClickable() {
        webDriver.get("https://google.com/");
        WebElement element = new WebDriverWait(webDriver, 5).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")));
        assertTrue(element.isDisplayed());
    }
    
    @Test
    public void testPresenceOfElement() {
        webDriver.get("https://google.com/");
        WebElement element = new WebDriverWait(webDriver, 5).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")));
        assertTrue(element.isDisplayed());
    }
    
    @Test
    public void testTitleContains() {
        webDriver.get("https://google.com/");
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]"))
                .click();
        Boolean element = new WebDriverWait(webDriver, 5).until(
                ExpectedConditions.titleContains("Doodle Google"));
        assertTrue(element);
    }
    
    @Test
    public void testTextToBePresent() {
        webDriver.get("https://ps.ug.edu.pl:8443/login.web");
        final WebElement select = webDriver.findElement(By.xpath("//*[@id=\"formLogin\"]/div[1]/div/div[1]/span/select"));
        Boolean element = new WebDriverWait(webDriver, 5).until(
                ExpectedConditions.textToBePresentInElement(select, "Student"));
        assertTrue(element);
    }
    
}
