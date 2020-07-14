package SeleniumPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fox {
    private WebDriver driver;
    @FindBy(css="[type='search'][name='q'][class='search-bar__input']")
      WebElement search;
    //constructor
    public Fox(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    public void searchItem(String item) throws InterruptedException {
    	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(search));
    	Thread.sleep(2000);
    	search.click();
    	search.clear();
    	search.sendKeys(item);
    	search.sendKeys(Keys.ENTER);
        }
}
