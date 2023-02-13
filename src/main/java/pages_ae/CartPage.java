package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public List<WebElement> getProductListAddedToCart(){
        return driver.findElements(By.xpath("//*/tbody/tr"));
    }
    public WebElement getQuantity (){
        return driver.findElement(By.className("disabled"));
    }
    public WebElement getProceedToCheckoutButton(){
        return driver.findElement(By.xpath("//*[@class='col-sm-6']/a"));
    }
    public WebElement getProceedToRegisterButton(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-center']/a")));
    }
    public List<WebElement> getRemoveFromCartButtons(){
        return driver.findElements(By.className("cart_quantity_delete"));
    }
}
