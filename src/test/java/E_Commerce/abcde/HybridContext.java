package E_Commerce.abcde;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HybridContext extends Setup {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String itemsToBeSelected = "Air Jordan 9 Retro";

		AndroidDriver<AndroidElement> driver = capabilitiesMethod("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("abcd");

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
						+ itemsToBeSelected + "\").instance(0))"));
		WebElement w = driver.findElements(By.xpath("//android.widget.LinearLayout")).get(0);
		w.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.context("NATIVE_APP");

	}

}
