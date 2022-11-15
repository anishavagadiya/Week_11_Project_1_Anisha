package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.Firefox.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.Edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong browser Name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("page title is : " + title);

        // Get Current URL
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Get Page Sourcecode
        System.out.println("page source: " + driver.getPageSource());

        //Find the Email Field element and send the email
        WebElement emailField = driver.findElement(By.id("Email"));

        //type email to email field
        emailField.sendKeys("test123@gmail.com");

        //Find the Password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("123456");

        driver.quit();


    }
}