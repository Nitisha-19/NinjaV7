package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AffiliatePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC06_AddAffiliate extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(
        groups = {"regression"},
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testAddAffiliate() {

        logger.debug("===== Starting TC06_AddAffiliate =====");

        try {

            logger.debug("Initializing HomePage");
            HomePage hp = new HomePage(getDriver());

            logger.debug("Clicking My Account");
            hp.clickMyAccount();

            logger.debug("Navigating to Login page");
            hp.goToLogin();

            logger.debug("Initializing LoginPage");
            LoginPage lp = new LoginPage(getDriver());

            logger.debug("Entering login email");
            lp.setEmail("sid@cloudberry.services");

            logger.debug("Entering login password");
            lp.setPwd("Test123");

            logger.debug("Submitting login");
            lp.clickLogin();

            logger.debug("Initializing AffiliatePage");
            AffiliatePage ap = new AffiliatePage(getDriver());

            logger.debug("Navigating to Affiliate form");
            ap.navigateToAffiliateForm();

            logger.debug("Filling affiliate details");
            ap.fillAffiliateDetails(
                    "CloudBerry",
                    "cloudberry.services",
                    "123456",
                    "Shadab Siddiqui"
            );

            logger.debug("Validating affiliate creation");

            try {
                Assert.assertTrue(
                        ap.isAffiliateAdded(),
                        "Affiliate details not added successfully."
                );
                logger.debug("Affiliate creation validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Affiliate creation validation FAILED", ae);
                captureScreen("testAddAffiliate");
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred in TC06_AddAffiliate", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC06_AddAffiliate =====");
    }
}
