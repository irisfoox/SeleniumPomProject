package SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GolfShirts {
      private WebDriver driver;
      @FindBy(id="product-price-170588")
        WebElement shirts;
      //constructor
      public GolfShirts(WebDriver driver) {
    	  this.driver=driver;
    	  PageFactory.initElements(driver, this);
      }
      public double getPrice() throws InterruptedException {
         new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(shirts)); 
    	 shirts.click();
    	 Thread.sleep(5000);
         String str=((shirts.getText().substring(shirts.getText().indexOf(" ")+1)));
         double price=Double.parseDouble(str);
         System.out.println("price for Golf shirt: "+price+" INS");
         return price;
      }
}
