package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import properties.Config;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            try {
                webDriver.set(createDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() throws IOException {


        WebDriver driver = null; // Selenium
        switch (Config.getBrowserType()) {


            case "chrome" -> {

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver"); //going to pointer to the base directory of the project

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver"); //going to pointer to the base directory of the project

                FirefoxOptions firefoxoptions = new FirefoxOptions();
                firefoxoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxoptions);
            }
        }

        if (driver != null) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
