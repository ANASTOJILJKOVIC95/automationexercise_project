package AutomationExerciseSite;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomationExerciseSite extends BaseTest_ae {

    @Test(priority = 1)
    @Description("Test case 1: Register user")
    public void registerUser() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getSingupForm().isDisplayed(),
                "Sing up form is not displayed");

        loginPage.getNameSingUpInput().sendKeys("Ana Stojiljkovic");
        loginPage.getEmailSingupInput().sendKeys(email);
        loginPage.getSingupButton().click();

        softAssert.assertEquals(registerPage.enterAccountText().getText(),
                "Enter Account Information",
                "Text is not as expected or is not visible");

        registerPage.getTitleRadioButton("female").click();
        registerPage.getNameInput().clear();
        registerPage.getNameInput().sendKeys("Ana Stojiljkovic");
        Assert.assertTrue(!registerPage.getEmailInput().isEnabled(), "Email should already be inputed and disabled");
        registerPage.getPasswordInput().sendKeys("ana1234");
        registerPage.selectDay("31");
        registerPage.selectMonth("5");
        registerPage.selectYear("1995");
        registerPage.newsLetterCheckBox().click();
        registerPage.specialOffersCheckBox().click();
        registerPage.getFirstNameInput().sendKeys("Ana");
        registerPage.getLasttNameInput().sendKeys("Stojiljkovic");
        registerPage.getCompanyInput().sendKeys("ITBootcamp");
        registerPage.getAddress1Input().sendKeys("Sunset Boulevard");
        registerPage.getAddress2Input().sendKeys("Hollywood Boulevard");
        registerPage.selectCountry("United States");
        registerPage.getStateInput().sendKeys("California");
        registerPage.getCityInput().sendKeys("Los Angeles");
        registerPage.getZipCodeInput().sendKeys("90001");
        registerPage.getMobileNumberInput().sendKeys("0800001000");
        registerPage.getCreateAccountButton().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "account_created",
                "Account is not created");

        registerPage.getContinueButton().click();
        navPage.ifAdShownNavigateTo("");
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "Account is not logged in");
        navPage.getLogoutButton().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Account is not logged out");
    }

    @Test(priority = 2)
    @Description("Test Case 2: Login User with correct email and password")
    public void loginWithValidCredentials() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getLoginForm().isDisplayed(),
                "Login form is not displayed");
        loginPage.geteEmailLoginInput().sendKeys(email);
        loginPage.getpasswordLoginInput().sendKeys("ana1234");
        loginPage.getLoginButton().click();
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "Account is not logged in");
        navPage.getLogoutButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Account is not logged out");
    }

    @Test(priority = 3)
    @Description("Test Case 3: Login User with incorrect email and password")
    public void loginWithIncorrectEmailandPassword() {

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getLoginForm().isDisplayed(),
                "Login form is not displayed");

        loginPage.geteEmailLoginInput().sendKeys("invalid@email.com");
        loginPage.getpasswordLoginInput().sendKeys("invalidpass");
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed(),
                "Error message is not displayed when logging in whit invalid credentials");

    }

    @Test(priority = 4)
    @Description("Test Case 4: Logout User")
    public void logoutUser() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getLoginForm().isDisplayed(),
                "Login form is not displayed");
        loginPage.geteEmailLoginInput().sendKeys(email);
        loginPage.getpasswordLoginInput().sendKeys("ana1234");
        loginPage.getLoginButton().click();
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "Account is not logged in");
        navPage.getLogoutButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Account is not logged out");
    }

    @Test(priority = 5)
    @Description("Test Case 5: Register User with existing email")
    public void registerUserWithExistingEmail() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getSingupForm().isDisplayed(),
                "Sing up form is not displayed");

        loginPage.getNameSingUpInput().sendKeys("Ana Stojiljkovic");
        loginPage.getEmailSingupInput().sendKeys(email);
        loginPage.getSingupButton().click();
        Assert.assertTrue(loginPage.getErrorSigninMessage().isDisplayed(),
                "Error message is not displayed when register with existing email");
    }

    @Test(priority = 6)
    @Description("Test Case 6: Contact Us Form")
    public void contactUsForm() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getContactUsButton().click();

        Assert.assertTrue(contactUsPage.contactUsForm().isDisplayed(),
                "Contact form is not displayed");

        contactUsPage.getNameInput().sendKeys("Ana Stojiljkovic");
        contactUsPage.getEmailInput().sendKeys(email);
        contactUsPage.getSubjectInput().sendKeys("Subject");
        contactUsPage.getMessageInput().sendKeys("This is the message");
        contactUsPage.getUploadFile().sendKeys(helper.apsolutPath("test_data/back.jpg"));
        contactUsPage.getSubmitButton().click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(contactUsPage.getSuccessMessage().getText(),
                "Success! Your details have been submitted successfully.",
                "There is no 'success' message");

        contactUsPage.getHomeButton().click();
        navPage.ifAdShownNavigateTo("");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl, "Not on home page");
    }
    @Test(priority = 7)
    @Description("Test Case 7: Verify Test Cases Page")
    public void verifyTestCasesPage (){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getTestCasesButton().click();
        navPage.ifAdShownNavigateTo("test_cases");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"test_cases","Not on 'test cases' page.");
    }
    @Test(priority = 8)
    @Description("Test Case 8: Verify All Products and product detail page")
    public void verifyAllProducts(){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"products",
                "Not on 'Products' page");
        productPage.getViewDetails().get(0).click();

        Assert.assertEquals(driver.getCurrentUrl(),
        baseUrl+"product_details/1",
                "Not on 'product details' page");

    }
   @Test(priority = 9 )
    @Description("Test Case 9: Search Product")
    public void searchProduct() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"products",
                "Not on 'Products' page");
        productPage.getSearchBox().sendKeys("men");
        productPage.getSearchButton().click();

        wait.until(ExpectedConditions.visibilityOfAllElements(productPage.getProductName()));

        for (int i = 0; i < productPage.getProductName().size(); i++) {

           Assert.assertTrue(productPage.getProductName().get(i).getText().toLowerCase().contains("men"),
                   "Products on list does not contain 'men'");
        }
    }


    @Test(priority = 10)
    @Description("Test Case 10: Verify Subscription in home page")
    public void verifySubscription(){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        actions.scrollToElement(homePage.footer()).perform();
        homePage.getSubscriptionBox().sendKeys(email);
        homePage.getSubscriptionButton().click();
        Assert.assertTrue(homePage.getSubscriptionMessage().isDisplayed(),
                "Message of succsessful subscription isn't visible");


    }
    @Test(priority = 11)
    @Description("Test Case 11: Verify Subscription in Cart page")
    public void verifySubscriptionInCartPage(){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getCartButton().click();;
        actions.scrollToElement(homePage.footer());
        homePage.getSubscriptionBox().sendKeys(email);
        homePage.getSubscriptionButton().click();
        Assert.assertTrue(homePage.getSubscriptionMessage().isDisplayed(),
                "Message of succsessful subscription isn't visible");
    }
    @Test(priority = 12)
    @Description("Test Case 12: Add Products in Cart")
    public void addToCart (){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");

        actions.moveToElement(productPage.getAllProducts().get(0)).perform();
        productPage.getAddToCartButton().get(0).click();
        productPage.getContinueShoppingButton().click();

        actions.moveToElement(productPage.getAllProducts().get(2)).perform();
        productPage.getAddToCartButton().get(2).click();
        productPage.getContinueShoppingButton();

        navPage.getCartButton().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartPage.getProductListAddedToCart()));
        Assert.assertEquals(cartPage.getProductListAddedToCart().size(),
                2,
                "Number of products added to cart is not as expected");
    }
    @Test(priority = 13)
    @Description("Test Case 13: Verify Product quantity in Cart")
    public void productQuantityInCart()  {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"products",
                "Not on 'Products' page");
        productPage.getViewDetails().get(0).click();
        productPage.getProductQuantity().clear();
        productPage.getProductQuantity().sendKeys("4");
        productPage.getAddToCartButtonViewDetailPage().click();
        productPage.getViewCartButton().click();
        navPage.getCartButton().click();
       Assert.assertEquals(cartPage.getQuantity().getText(), "4",
        "Quantity of product is not as expected");
    }
    @Test(priority = 14)
    @Description("Test Case 14: Place Order: Register while Checkout")
    public void registerWhileCheckout()  {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");

        actions.moveToElement(productPage.getAllProducts().get(0)).perform();
        productPage.getAddToCartButton().get(0).click();
        productPage.getContinueShoppingButton().click();

        actions.moveToElement(productPage.getAllProducts().get(1)).perform();
        productPage.getAddToCartButton().get(1).click();
        productPage.getContinueShoppingButton().click();

        navPage.getCartButton().click();
        cartPage.getProceedToCheckoutButton().click();
       cartPage.getProceedToRegisterButton().click();

        loginPage.getNameSingUpInput().sendKeys("Ana Stojiljkovic");
        loginPage.getEmailSingupInput().sendKeys("n"+email);
        loginPage.getSingupButton().click();

        softAssert.assertEquals(registerPage.enterAccountText().getText(),
                "Enter Account Information",
                "Text is not as expected or is not visible");

        registerPage.getTitleRadioButton("female").click();
        registerPage.getNameInput().clear();
        registerPage.getNameInput().sendKeys("Ana Stojiljkovic");
        Assert.assertTrue(!registerPage.getEmailInput().isEnabled(), "Email should already be inputed and disabled");
        registerPage.getPasswordInput().sendKeys("ana1234");
        registerPage.selectDay("31");
        registerPage.selectMonth("5");
        registerPage.selectYear("1995");
        registerPage.newsLetterCheckBox().click();
        registerPage.specialOffersCheckBox().click();
        registerPage.getFirstNameInput().sendKeys("Ana");
        registerPage.getLasttNameInput().sendKeys("Stojiljkovic");
        registerPage.getCompanyInput().sendKeys("ITBootcamp");
        registerPage.getAddress1Input().sendKeys("Sunset Boulevard");
        registerPage.getAddress2Input().sendKeys("Hollywood Boulevard");
        registerPage.selectCountry("United States");
        registerPage.getStateInput().sendKeys("California");
        registerPage.getCityInput().sendKeys("Los Angeles");
        registerPage.getZipCodeInput().sendKeys("90001");
        registerPage.getMobileNumberInput().sendKeys("0800001000");
        registerPage.getCreateAccountButton().click();
        registerPage.getContinueButton().click();
        navPage.ifAdShownNavigateTo("");
        navPage.getCartButton().click();
        cartPage.getProceedToCheckoutButton().click();

        Assert.assertTrue(checkoutPage.getAdress().isDisplayed(), "Adress on checkout page is not visible" );
        checkoutPage.getCommentInput().sendKeys("This is the comment for checkout");
        checkoutPage.getPlaceOrderButton().click();
        checkoutPage.getNameOnCardInput().sendKeys("Ana Stojiljkovic");
        checkoutPage.getCardNumberInput().sendKeys("1231-12131");
        checkoutPage.getCVCInput().sendKeys("123");
        checkoutPage.getExpirationMonthInput().sendKeys("10");
        checkoutPage.getExpirationYearInput().sendKeys("2023");
        checkoutPage.getConfirmButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"),
                "Paymant is not done");

        navPage.getDeleteAccountButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("delete_account"),
                "Account is not deleted");
    }
    @Test (priority = 15)
    @Description("Test Case 15: Place Order: Register before Checkout")
    public void registerBeforCheckout(){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getSingupForm().isDisplayed(),
                "Sing up form is not displayed");

        loginPage.getNameSingUpInput().sendKeys("Ana Stojiljkovic");
        loginPage.getEmailSingupInput().sendKeys("m"+email);
        loginPage.getSingupButton().click();

        softAssert.assertEquals(registerPage.enterAccountText().getText(),
                "Enter Account Information",
                "Text is not as expected or is not visible");

        registerPage.getTitleRadioButton("female").click();
        registerPage.getNameInput().clear();
        registerPage.getNameInput().sendKeys("Ana Stojiljkovic");
        Assert.assertTrue(!registerPage.getEmailInput().isEnabled(), "Email should already be inputed and disabled");
        registerPage.getPasswordInput().sendKeys("ana1234");
        registerPage.selectDay("31");
        registerPage.selectMonth("5");
        registerPage.selectYear("1995");
        registerPage.newsLetterCheckBox().click();
        registerPage.specialOffersCheckBox().click();
        registerPage.getFirstNameInput().sendKeys("Ana");
        registerPage.getLasttNameInput().sendKeys("Stojiljkovic");
        registerPage.getCompanyInput().sendKeys("ITBootcamp");
        registerPage.getAddress1Input().sendKeys("Sunset Boulevard");
        registerPage.getAddress2Input().sendKeys("Hollywood Boulevard");
        registerPage.selectCountry("United States");
        registerPage.getStateInput().sendKeys("California");
        registerPage.getCityInput().sendKeys("Los Angeles");
        registerPage.getZipCodeInput().sendKeys("90001");
        registerPage.getMobileNumberInput().sendKeys("0800001000");
        registerPage.getCreateAccountButton().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "account_created",
                "Account is not created");

        registerPage.getContinueButton().click();
        navPage.ifAdShownNavigateTo("");

        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");

        actions.moveToElement(productPage.getAllProducts().get(0)).perform();
        productPage.getAddToCartButton().get(0).click();

        productPage.getContinueShoppingButton().click();

        actions.moveToElement(productPage.getAllProducts().get(1)).perform();
        productPage.getAddToCartButton().get(1).click();

        productPage.getContinueShoppingButton().click();

        navPage.getCartButton().click();
        cartPage.getProceedToCheckoutButton().click();

        Assert.assertTrue(checkoutPage.getAdress().isDisplayed(), "Adress on checkout page is not visible" );
        checkoutPage.getCommentInput().sendKeys("This is the comment for checkout");
        checkoutPage.getPlaceOrderButton().click();
        checkoutPage.getNameOnCardInput().sendKeys("Ana Stojiljkovic");
        checkoutPage.getCardNumberInput().sendKeys("1231-12131");
        checkoutPage.getCVCInput().sendKeys("123");
        checkoutPage.getExpirationMonthInput().sendKeys("10");
        checkoutPage.getExpirationYearInput().sendKeys("2023");
        checkoutPage.getConfirmButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"),
                "Paymant is not done");

    }
    @Test(priority = 16)
    @Description("Test Case 16: Place Order: Login before Checkout")
    public  void LoginBeforCheckout(){
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getSignupLoginButton().click();
        softAssert.assertTrue(loginPage.getLoginForm().isDisplayed(),
                "Login form is not displayed");
        loginPage.geteEmailLoginInput().sendKeys("m"+email);
        loginPage.getpasswordLoginInput().sendKeys("ana1234");
        loginPage.getLoginButton().click();
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "Account is not logged in");

        Assert.assertTrue(checkoutPage.getAdress().isDisplayed(), "Adress on checkout page is not visible" );
        checkoutPage.getCommentInput().sendKeys("This is the comment for checkout");
        checkoutPage.getPlaceOrderButton().click();
        checkoutPage.getNameOnCardInput().sendKeys("Ana Stojiljkovic");
        checkoutPage.getCardNumberInput().sendKeys("1231-12131");
        checkoutPage.getCVCInput().sendKeys("123");
        checkoutPage.getExpirationMonthInput().sendKeys("10");
        checkoutPage.getExpirationYearInput().sendKeys("2023");
        checkoutPage.getConfirmButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"),
                "Paymant is not done");
    }
    @Test(priority = 17)
    @Description("Test Case 17: Remove Products From Cart")
    public void RemoveProductsFromCart() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Home page is not opened");
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");

        actions.moveToElement(productPage.getAllProducts().get(0)).perform();
        productPage.getAddToCartButton().get(0).click();

        productPage.getContinueShoppingButton().click();

        navPage.getCartButton().click();

        cartPage.getRemoveFromCartButtons().get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.getRemoveFromCartButtons().size(), 0,
                "Product is not deleted");
    }
    @Test(priority = 18)
    @Description("Test Case 18: View Category Products")
    public void viewCategoryProducts(){
        homePage.getWomenCategoryButton().click();
        homePage.getDressCategoryButton().click();

        navPage.ifAdShownNavigateTo("category_products/1");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"category_products/1",
                "Dress category is not opened");

        homePage.getMenCategoryLink().click();
        homePage.getTshirtsCategoryButton().click();

         navPage.ifAdShownNavigateTo("category_products/3");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"category_products/3",
                "T-shirt category is not opened");
    }
    @Test(priority = 19)
    @Description("Test Case 19: View & Cart Brand Products")
    public void viewCartBrandProducts() {
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");

        homePage.getPoloBrandButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"brand_products/Polo",
                "Not on Polo brand products list");

        homePage.getMadameBrandButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"brand_products/Madame",
                "Not on Madame brand products list");
    }
   @Test (priority = 20)
   @Description("Test Case 20: Search Products and Verify Cart After Login")
   public void searchProductAndVerifyCartAfterLogin() {
       navPage.getProductsButton().click();
       navPage.ifAdShownNavigateTo("products");

       productPage.getSearchBox().sendKeys("red");
       productPage.getSearchButton().click();

       for (int i = 0; i < productPage.getProductName().size(); i++) {

           Assert.assertTrue(productPage.getProductName().get(i).getText().toLowerCase().contains("red"),
                   "Products on list does not contain 'red'");
       }

       for (int i = 0; i < productPage.getAddToCartButton().size(); i++) {
           actions.moveToElement(productPage.getAllProducts().get(i)).perform();
           productPage.getAddToCartButton().get(i).click();
           productPage.getContinueShoppingButton().click();
       }

       navPage.getCartButton().click();
       Assert.assertEquals(cartPage.getProductListAddedToCart().size(),
               3,
               "Number of products in cart are not as expected");

       navPage.getSignupLoginButton().click();
       loginPage.geteEmailLoginInput().sendKeys(email);
       loginPage.getpasswordLoginInput().sendKeys("ana1234");
       loginPage.getLoginButton().click();

       navPage.getCartButton().click();
       Assert.assertEquals(cartPage.getProductListAddedToCart().size(),
               3,
               "Number of products in cart are not as expected");
   }
    @Test(priority = 21)
    @Description("Test Case 21: Add review on product")
    public void addReviewOnProduct(){
        navPage.getProductsButton().click();
        navPage.ifAdShownNavigateTo("products");
        productPage.getViewDetails().get(0).click();

        productPage.getReviewNameInput().sendKeys("Ana");
        productPage.getReviewEmailInput().sendKeys(email);
        productPage.getReviewTextInput().sendKeys("This the review text");
        productPage.getSendReviewButton().click();
        Assert.assertTrue(productPage.getReviewSuccsessfulySentMessage().isDisplayed(),
                "Review is not sent");
    }
    @Test(priority = 22)
    @Description("Test Case 22: Add to cart from Recommended items")
    public void addToCartFromRecommendedItems(){
        actions.scrollToElement(homePage.footer()).perform();
        Assert.assertTrue(homePage.getRecommendedItems().isDisplayed(),
                "Recommended items are not displayed");
        homePage.getRecommendedItemAddToCartButton().click();
        productPage.getContinueShoppingButton().click();
        navPage.getCartButton().click();
        Assert.assertEquals(cartPage.getProductListAddedToCart().size(),
                1,
                "Recommended item is not added to cart");
    }



    @Test(priority = 23)
    @Description("TC 23: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {
        actions.scrollToElement(homePage.footer());
        Assert.assertEquals(homePage.getSubscriptionBox().isDisplayed(), "Page didn't scroll down");
        homePage.getScrollUpArrow().click();
        Assert.assertTrue(homePage.getHomePageText().isDisplayed(), "Page didnt scroll up");

    }

    @Test(priority = 24)
    @Description("TC 24: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() {
        actions.scrollToElement(homePage.footer());
        actions.scrollToElement(homePage.header());
        Assert.assertTrue(homePage.getHomePageText().isDisplayed(), "Page didnt scroll up");
    }
}



