package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC05_AddToWishList extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC05_AddToWishList.class);

    @Test(
        groups = {"regression"},
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testAddToWishList() {

        logger.debug("===== Starting TC05_AddToWishList =====");

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

            logger.debug("Initializing CategoryPage");
            CategoryPage cp = new CategoryPage(getDriver());

            logger.debug("Navigating to Laptops & Notebooks");
            cp.clickLaptopsAndNotebooks();

            logger.debug("Clicking Show All");
            cp.clickShowAll();

            logger.debug("Selecting HP product");
            cp.selectHPProduct();

            logger.debug("Initializing ProductPage");
            ProductPage pp = new ProductPage(getDriver());

            logger.debug("Adding product to Wishlist");
            pp.addToWishlist();

            logger.debug("Validating wishlist success message");

            try {
                Assert.assertTrue(
                        pp.isSuccessMessageDisplayed(),
                        "Wishlist message not shown."
                );
                logger.debug("Wishlist validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Wishlist validation FAILED", ae);
                captureScreen("testAddToWishList");
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred in TC05_AddToWishList", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC05_AddToWishList =====");
    }
}
