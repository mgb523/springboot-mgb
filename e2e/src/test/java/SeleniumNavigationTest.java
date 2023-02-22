import com.javainuse.SeleniumBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumNavigationTest extends SeleniumBase {

    public static String LINK_SHORTENER_PAGE = "http://localhost:4200";

    public static String URL_TEXT_BOX_CSS = "#link";
    public static String SHORTENED_URL_TEXT_BOX_CSS = "#shortUrl";

    public static String SHORTEN_URL_BUTTON_CSS = "#shortenUrl";
    public static String SHORTENED_URL_BUTTON_CSS = "#copyShortenedUrl";

    public static WebDriver driver;


    @BeforeAll
    public static void setUp() {
        driver = startChromeDriver();
        navigateTo(driver, LINK_SHORTENER_PAGE);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void launchLinkShortener() {
        navigateTo(driver, LINK_SHORTENER_PAGE);
    }

    @Test
    public void testShortenLink() throws InterruptedException {
        String urlToShorten = "https://www.nxp.com/";
        driver.findElement(By.cssSelector(URL_TEXT_BOX_CSS)).sendKeys(urlToShorten);
        driver.findElement(By.cssSelector(SHORTEN_URL_BUTTON_CSS)).click();
        Thread.sleep(500);

        WebElement shortenedUrl = driver.findElement(By.cssSelector(SHORTENED_URL_TEXT_BOX_CSS));
        assertTrue(driver.findElement(By.cssSelector(SHORTENED_URL_TEXT_BOX_CSS))
                .getAttribute("class").contains("touched"));

        driver.findElement(By.cssSelector(SHORTENED_URL_BUTTON_CSS)).click();
        navigateTo(driver, shortenedUrl.getAttribute("value"));

        assertTrue(driver.getCurrentUrl().equals(urlToShorten));
    }
}
