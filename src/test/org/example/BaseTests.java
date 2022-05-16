package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTests {
    private WebDriver driver;

    @Test
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://teamorg2-dev-ed.my.salesforce.com/");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

        usernameBox.sendKeys("incubatorteam@oktana.com");
        passwordBox.sendKeys("incubator2024");

        loginButton.click();

        String siteTitle = driver.getTitle();

        Assert.assertEquals(siteTitle, "Home | Salesforce", "El login fallo !");

        Thread.sleep(7000);

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
