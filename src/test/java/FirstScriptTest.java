package dev.selenium.getting_started;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Collections;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstScriptTest {

    @Test
    public void eightComponents() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--user-data-dir=/home/juba/tr/selenium/data/1");
 
    
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", null);

        // Changing the user agent / browser fingerprint
        options.addArguments("window-size=1920,1080");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");




        WebDriver driver = new ChromeDriver(options);
        driver.get("https://youtube.com/shorts");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement bodyElement = driver.findElement(By.tagName("body"));

        for (int i = 0 ; i < 100; i++) {

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bodyElement.sendKeys(Keys.ARROW_DOWN); // Simulate pressing the arrow down key
        }

        driver.quit();
    }

}

