package E_Commerce.abcde;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ValidateTotalPrice extends Setup {
	public static void main(String args[]) throws MalformedURLException {
		String[] itemsToBeSelected = { "Air Jordan 9 Retro", "PG 3" };

		AndroidDriver<AndroidElement> driver = capabilitiesMethod("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		for (int i = 0; i < itemsToBeSelected.length; i++) {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
							+ itemsToBeSelected[i] + "\").instance(0))"));
			WebElement w = driver.findElements(By.xpath("//android.widget.LinearLayout")).get(0);
			w.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		int totalObjects = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(totalObjects);
		
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvCartProductList\")).scrollIntoView(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productPrice\"))"));
		double price = 0.0;
		for (int i = 0; i < totalObjects; i++) {
			price = price + Double.parseDouble(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
					
		}
		String givenTotalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1);
		System.out.println(Double.parseDouble(givenTotalPrice));
		System.out.println(price);
		Assert.assertEquals(Double.parseDouble(givenTotalPrice), price);

	}

}
