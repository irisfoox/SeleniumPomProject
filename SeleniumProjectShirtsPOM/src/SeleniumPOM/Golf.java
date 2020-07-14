package SeleniumPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Golf {
      private WebDriver driver;
      @FindBy(css="[class='search icon-expandable desktop-search'][data-content='search-expanded']")
        WebElement search;
      @FindBy(css="[id='search'][name='q']")
        WebElement text;
      
      //constructor
      public Golf(WebDriver driver) {
    	  this.driver=driver;
    	  PageFactory.initElements(driver, this);
         }
      public void searchItem(String item) {
    	  new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(search));
    	  search.click();
    	  new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(text));
    	  text.click();
    	  text.sendKeys(item);
    	  text.sendKeys(Keys.ENTER);
      	  }
}
