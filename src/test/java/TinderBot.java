import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TinderBot {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement activeElement;


    public void  driverInfo() {
        ChromeOptions simo = new ChromeOptions();
        simo.addArguments("--disable-blink-features=AutomationControlled");
        simo.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        simo.addArguments("--user-data-dir=acc1");

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver(simo);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bodyElement = driver.findElement(By.tagName("body"));
    }


    public void intercart() {
        for (int i = 0; i < 20; i++) {
            try {
                activeElement.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }


    public void start() {
        try {
            driver.get("https://youtube.com/shorts");
            activeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"like-button\"]/yt-button-shape/label/button")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        intercart();
    }
    
    public void blati() {
        try {
            Thread.sleep(100000000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        }

    public static void main(String[] args) {
        TinderBot bot = new TinderBot();
        bot.driverInfo();
        bot.start();
    }
}

