package E_Commerce.abcde;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

public class ValidatePopUp extends Setup {
	public static void main(String args[]) throws MalformedURLException {
		String[] itemsToBeSelected = { "Air Jordan 9 Retro"};

		AndroidDriver<AndroidElement> driver = capabilitiesMethod("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		for (int i = 0; i < itemsToBeSelected.length; i++) {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
							+ itemsToBeSelected[i] + "\").instance(0))"));
			WebElement w = driver.findElements(By.xpath("//android.widget.LinearLayout")).get(0);
			w.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElementByClassName("android.widget.CheckBox").click();
		TouchAction t = new TouchAction(driver);
		WebElement w = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(LongPressOptions.longPressOptions().withElement(element(w)).withDuration(Duration.ofMillis(5))).release().perform();
		System.out.println(driver.findElementByClassName("android.widget.FrameLayout").isDisplayed());
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}
}
