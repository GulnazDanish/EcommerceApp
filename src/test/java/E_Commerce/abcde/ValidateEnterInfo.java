package E_Commerce.abcde;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ValidateEnterInfo extends Setup {
	public static void main(String args[]) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilitiesMethod("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String message = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(message);

	}

}
