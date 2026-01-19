package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC02_Login extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC02_Login.class);

    @Test(
        groups = {"sanity", "regression", "datadriven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testLogin(String email, String pwd) {

        logger.debug("===== Starting TC02_Login =====");
        logger.debug("Test data -> Email: " + email);

        try {

            logger.debug("Initializing HomePage");
            HomePage hp = new HomePage(getDriver());

            logger.debug("Clicking MyAccount");
            hp.clickMyAccount();

            logger.debug("Navigating to Login page");
            hp.goToLogin();

            logger.debug("Initializing LoginPage");
            LoginPage lp = new LoginPage(getDriver());

            logger.debug("Entering email");
            lp.setEmail(email);

            logger.debug("Entering password");
            lp.setPwd(pwd);

            logger.debug("Clicking Login button");
            lp.clickLogin();

            logger.debug("Initializing AccountPage");
            AccountPage ap = new AccountPage(getDriver());

            boolean status = ap.getMyAccountConfirmation().isDisplayed();
            logger.debug("Login status displayed: " + status);

            try {
                Assert.assertTrue(status, "Login failed – My Account not displayed");
                logger.debug("Login validation PASSED");

                logger.debug("Performing logout steps");
                ap.clickMyAccountDropdown();
                ap.clickLogout();
                logger.debug("Logout successful");

            } catch (AssertionError ae) {
                logger.error("Login validation FAILED", ae);
                captureScreen("testLogin");
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred during TC02_Login execution", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC02_Login =====");
    }
}
