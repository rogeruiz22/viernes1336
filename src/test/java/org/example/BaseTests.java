package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        passwordBox.sendKeys("incubator2022");

        loginButton.click();

        Thread.sleep(7000);

        WebElement appLauncherButton = driver.findElement(By.xpath("//div[@data-aura-class='navexWorkspaceManager']//div[@role='navigation']//button"));
        appLauncherButton.click();

        driver.switchTo().activeElement();

        WebElement appLauncherSearchBox = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
        appLauncherSearchBox.sendKeys("Contact");
        appLauncherSearchBox.sendKeys(Keys.RETURN);

        WebElement selectAllCheckbox = driver.findElement(By.xpath("//span[@class='checkbox-container uiInput forceVirtualCheckbox uiInput--default']"));
        selectAllCheckbox.click();

        WebElement sendListEmailButton = driver.findElement(By.xpath("//div[text()='Send List Email']"));
        sendListEmailButton.click();

        driver.switchTo().activeElement();

        WebElement subjectBox = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
        subjectBox.sendKeys("Github Actions Email como prueba de que funciona");

        WebElement sendButton = driver.findElement(By.xpath("//button[text()='Send']"));
        sendButton.click();

        driver.quit();
    }

    public static void main(String[] args) throws Exception {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
