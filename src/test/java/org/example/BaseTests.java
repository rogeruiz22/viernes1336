package org.example;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://teamorg2-dev-ed.my.salesforce.com/");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

        usernameBox.sendKeys("incubatorteam@oktana.com");
        passwordBox.sendKeys("incubator2022");

        loginButton.click();

        Thread.sleep(7000);

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}