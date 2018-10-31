package tests;

import base.SetupTestDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

import java.net.MalformedURLException;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void teardown () {
        driver.quit();
    }



    // @BeforeClass
    // public void setup () {
    //     //Create a Chrome driver. All test classes use this.
    //     driver = new ChromeDriver();

    //     //Create a wait. All test classes use this.
    //     wait = new WebDriverWait(driver,15);

    //     //Maximize Window
    //     driver.manage().window().maximize();
    // }

    // @AfterClass
    // public void teardown () {
    //     driver.quit();
    // }
}
