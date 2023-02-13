package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement geteEmailLoginInput() {
        return driver.findElement(By.xpath("//*[@data-qa='login-email']"));
    }

    public WebElement getpasswordLoginInput() {
        return driver.findElement(By.xpath("//*[@data-qa='login-password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[@data-qa='login-button']"));
    }

    public WebElement getNameSingUpInput() {
        return driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
    }

    public WebElement getEmailSingupInput() {
        return driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
    }

    public WebElement getSingupButton() {
        return driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
    }

    public WebElement getSingupForm(){
        return driver.findElement(By.className("signup-form"));
    }
    public WebElement getLoginForm(){
        return driver.findElement(By.className("login-form"));
    }
    public WebElement getErrorLoginMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='login-form']/form/p")));
    }
    public WebElement getErrorSigninMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='signup-form']/form/p")));
    }

}