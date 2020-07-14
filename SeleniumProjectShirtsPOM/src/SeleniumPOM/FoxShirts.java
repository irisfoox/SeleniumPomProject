package SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoxShirts {
	private WebDriver driver;
	@FindBy (css="[class='product__price--on-sale']")
	   WebElement shirt1;
	//constructor
	public FoxShirts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public double getPrice() throws InterruptedException {
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(shirt1));
		String str=((shirt1.getText().substring(shirt1.getText().indexOf("$")+1)));
		double price=Double.parseDouble(str);
		System.out.println("price for Fox shirt: "+price*3.5+" INS");
		return price*3.5;        //$ into INS
	}

}
