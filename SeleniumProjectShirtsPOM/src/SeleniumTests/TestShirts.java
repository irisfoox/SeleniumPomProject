package SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumPOM.Fox;
import SeleniumPOM.FoxShirts;
import SeleniumPOM.Golf;
import SeleniumPOM.GolfShirts;

public class TestShirts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver","C://Program Files//Selenium//drivers//chrome83//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        Golf golf=new Golf(driver);
        GolfShirts golfS=new GolfShirts(driver);
        Fox fox=new Fox(driver);
        FoxShirts foxS=new FoxShirts(driver);
        
        driver.get("http://www.golfkids.co.il");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        golf.searchItem("çåìöåú");
        double golfShirt=golfS.getPrice();
        
        driver.get("https://foxfashion.sg");
        fox.searchItem("shirt");
        double foxShirt=foxS.getPrice();
        
        int persent=0;
        if(golfShirt<foxShirt) {
        	persent=(int)(100-(golfShirt/foxShirt*100));
        	System.out.println("Golf shirt is cheaper by "+persent+" % than Fox shirt");
        }
        if(golfShirt>foxShirt) {
        	persent=(int) (100-(foxShirt/golfShirt*100));
        	System.out.println("Fox shirt is cheaper by "+persent+" % than Golf shirt");
        }
        
        Thread.sleep(5000);
        driver.close();
        System.out.println("--END TEST--");
	}
}
