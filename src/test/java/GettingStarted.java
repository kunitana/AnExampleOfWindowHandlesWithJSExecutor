import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GettingStarted {

    @Test
    public void testWindowHandles() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","C:\\Users\\dmitry.kunitsyn\\IdeaProjects\\Testselenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://google.com");

        Set<String> oldWindow = driver.getWindowHandles();
        System.out.println("oldWindow ->" + oldWindow);

        ((JavascriptExecutor)driver).executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://yandex.com");

        Set<String> newWindow = driver.getWindowHandles();
        System.out.println("newWindow ->" + newWindow);

        driver.quit();
    }
}
