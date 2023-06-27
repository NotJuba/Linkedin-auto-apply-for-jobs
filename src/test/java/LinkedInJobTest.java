/*
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class LinkedInJobSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/home/juba/.config/google-chrome/");
        options.addArguments("--profile-directory=Profile 1");
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://www.linkedin.com/jobs/");
        sleep(5);
        
        String jobTitle = "Python developer";
        
        searchForJobTitle(driver, jobTitle);
        sleep(5);
        
        selectEasyJob(driver);
        sleep(5);
        
        findJobs(driver);
        
        driver.quit();
    }
    
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void searchForJobTitle(WebDriver driver, String jobTitle) {
        try {
            WebElement search = driver.findElement(By.xpath("/html/body/div[5]/header/div/div/div/div[2]/div[2]/div/div/input[1]"));
            sleep(1);
            search.sendKeys(jobTitle);
            sleep(2);
            search.sendKeys(Keys.RETURN);
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(5);
    }
    
    public static void selectEasyJob(WebDriver driver) {
        try {
            WebElement easyApply = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[4]/section/div/section/div/div/div/ul/li[8]/div/button"));
            easyApply.click();
        } catch (NoSuchElementException e) {
            // Handle exception
        }
    }
    
    public static void findJobs(WebDriver driver) {
        sleep(5);
        
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul.scaffold-layout__list-container li")));
            
            java.util.List<WebElement> listItems = driver.findElements(By.cssSelector("ul.scaffold-layout__list-container li"));
            
            for (WebElement item : listItems) {
                item.click();
                sleep(2);
                applyForJob(driver);
                sleep(10);
            }
        } catch (NoSuchElementException | TimeoutException e) {
            // Handle exception
        }
    }
    
    public static void writeInputs(WebDriver driver) {
        sleep(2);
        
        try {
            WebElement divElement = driver.findElement(By.className("pb4"));
            java.util.List<WebElement> inputElements = divElement.findElements(By.tagName("input"));
            
            String[] experienceTimes = {"4", "1", "2", "3"};
            
            for (WebElement ele : inputElements) {
                String experienceTime = experienceTimes[(int)(Math.random() * experienceTimes.length)];
                sleep(1);
                ele.sendKeys(experienceTime);
                sleep(1);
            }
        } catch (NoSuchElementException e) {
            // Handle exception
        }
    }
    
    public static void selectSomething(WebDriver driver) {
        try {
            WebElement selectElement = driver.findElement(By.cssSelector("select[data-test-text-entity-list-form-select]"));
            java.util.List<WebElement> options = selectElement.findElements(By.tagName("option"));
            options.get(2).click();  // Select the third option (index 2)
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(2);
    }
    
    public static void selectRation(WebDriver driver) {
        try {
            WebElement divParent = driver.findElement(By.tagName("fieldset"));
            java.util.List<WebElement> rationElements = divParent.findElements(By.tagName("label"));
            
            for (WebElement ration : rationElements) {
                sleep(1);
                ration.click();
                break;
            }
        } catch (NoSuchElementException e) {
            // Handle exception
        }
    }
    
    public static void handleInputs(WebDriver driver) {
        try {
            writeInputs(driver);
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(2);
        
        try {
            selectSomething(driver);
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(2);
        
        try {
            selectRation(driver);
        } catch (NoSuchElementException e) {
            // Handle exception
        }
    }
    
    public static void nextFunction(WebDriver driver) {
        try {
            WebElement button = driver.findElement(By.xpath("//button[text()='Next' or text()='Review']"));
            button.click();
        } catch (NoSuchElementException e) {
            try {
                WebElement next1 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/footer/div[2]/button[2]"));
                next1.click();
            } catch (NoSuchElementException e1) {
                try {
                    WebElement next2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/footer/div[2]/button[3]"));
                    next2.click();
                } catch (NoSuchElementException e2) {
                    // Handle exception
                }
            }
        }
    }
    
    public static void submitApplication(WebDriver driver) {
        try {
            WebElement button = driver.findElement(By.xpath("//button[text()='Submit application']"));
            button.click();
        } catch (NoSuchElementException e) {
            try {
                WebElement submitButton1 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/footer/div[3]/button[2]"));
                submitButton1.click();
            } catch (NoSuchElementException e1) {
                try {
                    WebElement submit1 = driver.findElement(By.xpath("//*[@id=\"ember396\"]"));
                    submit1.click();
                } catch (NoSuchElementException e2) {
                    try {
                        WebElement submit2 = driver.findElement(By.className("artdeco-button artdeco-button--2 artdeco-button--primary ember-view"));
                        submit2.click();
                    } catch (NoSuchElementException e3) {
                        // Handle exception
                    }
                }
            }
        }
    }
    
    public static void applyForJob(WebDriver driver) {
        try {
            WebElement applyButton = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[4]/div/div/main/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div[1]/div[3]/div/div/div/button"));
            sleep(1);
            applyButton.click();
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(2);
        
        try {
            WebElement nextButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/footer/div[2]/button"));
            nextButton.click();
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        sleep(2);
        
        nextFunction(driver);
        
        sleep(2);
        
        try {
            handleInputs(driver);
        } catch (NoSuchElementException e) {
            // Handle exception
        }
        
        nextFunction(driver);
        
        sleep(3);
        
        submitApplication(driver);
        sleep(4);
        
        try {
            WebElement close = driver.findElement(By.xpath("/html/body/div[3]/div/div/button"));
            close.click();
        } catch (NoSuchElementException e) {
            // Handle exception
        }
    }
}
*/
