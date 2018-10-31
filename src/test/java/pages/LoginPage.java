package pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String usenameId = "email";
    String passwordId = "password";
    String loginButtonId = "loginButton";
    String errorMessageUsernameXpath = "//*[@id=\"loginForm\"]/div[1]/div/div";
    String errorMessagePasswordXpath = "//*[@id=\"loginForm\"]/div[2]/div/div ";

    //*********Page Methods*********

    // public void loginToN11 (String username, String password){
    //     //Enter Username(Email)
    //     writeText(By.id(usenameId),username);
    //     //Enter Password
    //     writeText(By.id(passwordId), password);
    //     //Click Login Button
    //     click(By.id(loginButtonId));
    // }

    public void loginToN11 (XSSFRow row){
        //Enter Username(Email)
        writeText(By.id(usenameId),row.getCell(1).toString());
        //Enter Password
        writeText(By.id(passwordId), row.getCell(2).toString());
        //Click Login Button
        click(By.id(loginButtonId));
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
    }

}
