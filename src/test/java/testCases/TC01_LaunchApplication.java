package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(
        groups = {"sanity", "regression"},
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testLaunchApplication() {

        logger.debug("===== Starting TC01_LaunchApplication =====");

        try {
            logger.debug("Initializing HomePage object");
            HomePage hp = new HomePage(getDriver());

            logger.debug("Fetching page title");
            String actualTitle = getDriver().getTitle();
            String expectedTitle = "Your store of fun";

            logger.debug("Actual Title: " + actualTitle);
            logger.debug("Expected Title: " + expectedTitle);

            try {
                Assert.assertEquals(actualTitle, expectedTitle);
                logger.debug("Title validation PASSED");
            } catch (AssertionError ae) {
                logger.error("Title validation FAILED", ae);
                captureScreen("testLaunchApplication");
                throw ae; // important for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred in testLaunchApplication", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC01_LaunchApplication =====");
    }
}

