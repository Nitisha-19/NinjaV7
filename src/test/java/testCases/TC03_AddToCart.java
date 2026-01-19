package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CategoryPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    private static final Logger logger =
            LogManager.getLogger(TC03_AddToCart.class);

    @Test(
        groups = {"sanity", "regression"},
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    public void testAddToCart() {

        logger.debug("===== Starting TC03_AddToCart =====");

        try {

            logger.debug("Initializing CategoryPage");
            CategoryPage cp = new CategoryPage(getDriver());

            logger.debug("Clicking Laptops & Notebooks category");
            cp.clickLaptopsAndNotebooks();

            logger.debug("Clicking Show All");
            cp.clickShowAll();

            logger.debug("Selecting HP product");
            cp.selectHPProduct();

            logger.debug("Initializing ProductPage");
            ProductPage pp = new ProductPage(getDriver());

            logger.debug("Setting delivery date");
            pp.setDeliveryDate();

            logger.debug("Clicking Add to Cart button");
            pp.clickAddToCart();

            logger.debug("Validating Add to Cart success message");

            try {
                Assert.assertTrue(
                        pp.isSuccessMessageDisplayed(),
                        "Add to Cart Failed!"
                );
                logger.debug("Add to Cart validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Add to Cart validation FAILED", ae);
                captureScreen("testAddToCart");
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred in TC03_AddToCart", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.debug("===== Finished TC03_AddToCart =====");
    }
}
