package E_Commerce.abcde;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ValidateAddToCart extends Setup{
	public static void main(String args[]) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilitiesMethod("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);

		
		 for(int i=0;i<count;i++) 
		 {		 
			
			WebElement w= driver.findElements(By.xpath("//android.widget.LinearLayout")).get(i);
		 
			 if(w.findElement(By.id("com.androidsample.generalstore:id/productName")).getText().equalsIgnoreCase("PG 3"))
		  
			 {		  
				 w.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		 
				 break;
		 
			 }
		
		 }
		 
		 Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(), "PG 3");
		
	}
		  

}
