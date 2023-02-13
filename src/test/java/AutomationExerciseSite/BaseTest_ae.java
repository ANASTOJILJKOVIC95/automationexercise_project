package AutomationExerciseSite;

import Helper.Helper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages_ae.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public abstract class BaseTest_ae {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected NavigationPage navPage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected RegisterPage registerPage;
    protected ContactUsPage contactUsPage;
    protected HomePage homePage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;
    protected Random random;
    protected String baseUrl ="https://automationexercise.com/";
    protected String email;
    protected Helper helper;
    protected Actions actions;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.navPage = new NavigationPage(driver,wait);
        this.loginPage = new LoginPage(driver, wait);
        this.productPage = new ProductPage(driver,wait);
        this.contactUsPage = new ContactUsPage(driver,wait);
        this.softAssert = new SoftAssert();
        this.registerPage = new RegisterPage(driver,wait);
        this.homePage = new HomePage(driver, wait);
        this.cartPage = new CartPage(driver,wait);
        this.checkoutPage = new CheckoutPage(driver,wait);
        this.helper = new Helper();
        this.random = new Random();
        this.actions = new Actions(driver);
        int number = random.nextInt(200);
        this.email = "anastojiljkovic"+number+"@gmail.com";
    }

    @BeforeMethod
    public void beforeMethod (){
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
            if (result.getStatus() == ITestResult.FAILURE) {
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
                Files.copy(file.toPath(), new File("screenshots/" + result.getName() +
                        " - " + timestamp + ".png").toPath());
            }
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        navPage.getDeleteAccountButton().click();
        Thread.sleep(5000);
        driver.quit();
    }
}
