package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement contactUsForm(){
        return driver.findElement(By.cssSelector("div.contact-form"));
    }

    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("input[name='name']"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("input[name='email']"));
    }
    public WebElement getSubjectInput(){
        return driver.findElement(By.cssSelector("input[name='subject']"));
    }
    public WebElement getMessageInput(){
        return driver.findElement(By.cssSelector("textarea[name='message']"));
    }
    public WebElement getUploadFile(){
        return driver.findElement(By.cssSelector("input[name='upload_file']"));
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.cssSelector("input[name='submit']"));
    }
    public WebElement getHomeButton (){
        return driver.findElement(By.xpath("//*[@id='form-section']/a"));
    }
    public WebElement getSuccessMessage(){
        return driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
    }


}
