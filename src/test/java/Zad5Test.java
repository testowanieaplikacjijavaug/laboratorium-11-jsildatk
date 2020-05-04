import io.github.bonigarcia.seljup.SeleniumExtension;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
public class Zad5Test {
    
    private final WebDriver webDriver;
    
    public Zad5Test(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
    }
    
    @BeforeEach
    public void goToPage() {
        webDriver.get("https://google.com");
    }
    
    @Test
    public void test1() {
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("asdf");
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"))
                .click();
        
        try {
            String title = new WebDriverWait(webDriver, 10).until(new ExpectedCondition<String>() {
                @NullableDecl
                @Override
                public String apply(@NullableDecl WebDriver webDriver) {
                    return webDriver.getTitle();
                }
            });
            assertTrue(title.contains("asdf"));
        } catch ( Exception e ) {
            fail();
        }
    }
    
    @Test
    public void test2() {
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("koronawirus w polsce");
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"))
                .click();
        
        try {
            WebElement element = new WebDriverWait(webDriver, 10).until(new ExpectedCondition<WebElement>() {
                @NullableDecl
                @Override
                public WebElement apply(@NullableDecl WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//*[@id=\"rhs\"]/div[1]/div/div[1]/div"));
                }
            });
            
            assertEquals("Cases overview", element.getText());
        } catch ( Exception e ) {
            fail();
        }
    }
    
    @Test
    public void test3() {
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("xd");
        webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"))
                .click();
        
        try {
            Boolean isDisplayed = new WebDriverWait(webDriver, 10).until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"))
                            .isDisplayed();
                }
            });
            
            assertTrue(isDisplayed);
        } catch ( Exception e ) {
            fail();
        }
    }
    
}