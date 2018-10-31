package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import utils.excelutils.ExcelUtil;

public class LoginTests extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.


    @BeforeTest
    public void setupTestData () throws Exception{
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
    }


    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws Exception {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE Methods********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to N11
        //loginPage.loginToN11("onur@swtestacademy.com", "11223344");
        //Login to N11 with first row of the login data
        loginPage.loginToN11(ExcelUtil.getRowData(1));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        // loginPage.verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        loginPage.verifyLoginPassword(ExcelUtil.getCellData(1,4));
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () throws Exception {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE Methods********************
        homePage.goToN11();
        homePage.goToLoginPage();

        //Login to N11 with second row of the login data
        loginPage.loginToN11(ExcelUtil.getRowData(2));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify by 3rd row and 4th column
        loginPage.verifyLoginUserName(ExcelUtil.getCellData(2,3));
        //Verify by 3rd row and 5th column
        loginPage.verifyLoginPassword(ExcelUtil.getCellData(2,4));
    }

}
