package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeButton(){
        return driver.findElement(By.cssSelector("a[href='/']"));
    }
    public WebElement getProductsButton(){
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }
    public WebElement getCartButton(){
        return driver.findElement(By.cssSelector("a[href='/view_cart']"));
    }
    public WebElement getSignupLoginButton(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.cssSelector("a[href='/logout']"));
    }
    public WebElement getTestCasesButton(){
        return driver.findElement(By.cssSelector("a[href='/test_cases']"));
    }
    public WebElement getDeleteAccountButton (){
        return driver.findElement(By.cssSelector("a[href='/delete_account']"));
        }
    public WebElement getContactUsButton (){
        return driver.findElement(By.cssSelector("a[href='/contact_us']"));
    }
    public void ifAdShownNavigateTo(String page) {
        if (driver.getCurrentUrl().contains("#google_vignette")) {
            driver.navigate().to("https://automationexercise.com/" + page);
        }
    }

}




