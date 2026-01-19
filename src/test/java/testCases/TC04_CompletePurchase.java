package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC04_CompletePurchase extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC04_CompletePurchase.class);

    @Test(
        groups = {"sanity", "regression"},
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    public void testCompletePurchase() {

        logger.debug("===== Starting TC04_CompletePurchase =====");

        try {

            logger.debug("Initializing CategoryPage");
            CategoryPage cp = new CategoryPage(getDriver());

            logger.debug("Navigating to Laptops & Notebooks");
            cp.clickLaptopsAndNotebooks();

            logger.debug("Clicking Show All products");
            cp.clickShowAll();

            logger.debug("Selecting HP product");
            cp.selectHPProduct();

            logger.debug("Initializing ProductPage");
            ProductPage pp = new ProductPage(getDriver());

            logger.debug("Setting delivery date");
            pp.setDeliveryDate();

            logger.debug("Adding product to cart");
            pp.clickAddToCart();

            logger.debug("Proceeding to checkout");
            pp.clickCheckout();

            logger.debug("Initializing CheckoutPage");
            CheckoutPage cop = new CheckoutPage(getDriver());

            logger.debug("Clicking Login during checkout");
            cop.clickLogin();

            logger.debug("Initializing LoginPage");
            LoginPage lp = new LoginPage(getDriver());

            logger.debug("Entering login email");
            lp.setEmail("sid@cloudberry.services");

            logger.debug("Entering login password");
            lp.setPwd("Test123");

            logger.debug("Submitting login form");
            lp.clickLogin();

            logger.debug("Completing checkout process");
            cop.completeCheckout();

            logger.debug("Initializing ConfirmationPage");
            ConfirmationPage confirmationPage =
                    new ConfirmationPage(getDriver());

            logger.debug("Validating order placement");

            try {
                Assert.assertTrue(
                        confirmationPage.isOrderPlaced(),
                        "Order placement failed!"
                );
                logger.debug("Order placement validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Order placement validation FAILED", ae);
                captureScreen("testCompletePurchase");
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred in TC04_CompletePurchase", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC04_CompletePurchase =====");
    }
}
