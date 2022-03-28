package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utility.CarouselUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test83 
{

	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//Close Banner
		driver.findElement(By.xpath("//script[@id='omni_script']/following::button[1]")).click();
		Thread.sleep(5000);
		
		//Locate Carsouel Element
		WebElement slider = driver.findElement(By.xpath(
				"(//div[@id='container']/descendant::div[contains(@style,'translate')])[1]"));
		
		//testing Common Code
		CarouselUtility obj= new CarouselUtility();
		System.out.println(obj.getCountOfSlides(slider));
		System.out.println(obj.getTypeOfSlider(slider));
		System.out.println(slider.getCssValue("transform"));
		
		if (obj.areSlidesMovingAutomaticallyInSlider(slider))
		{
		  System.out.println("Moving autometically");
		  System.out.println(slider.getCssValue("transition"));
		  System.out.println(obj.getSlideMoveDuration(slider));
		  System.out.println(obj.getslideMovingStyle(slider));
		  System.out.println(obj.getDelayBetweenSlidesMove(slider));
		  System.out.println(obj.getMovingDirectionOfSlidesInSlider(slider));
		}
	
	   else
	    {
		  System.out.println("Not moving autometically");
	    }
  driver.close();
 }
}
