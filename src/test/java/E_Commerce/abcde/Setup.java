package E_Commerce.abcde;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Setup {
	public static AndroidDriver<AndroidElement> capabilitiesMethod(String device) throws MalformedURLException {
		File f = new File("General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (device.equalsIgnoreCase("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);

		}

		else if (device.equalsIgnoreCase("real")) {
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LenovoTAB");

		}
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;

	}

	public static AndroidDriver<AndroidElement> capabilitiesMethod(String device, String browser)
			throws MalformedURLException {
		File f = new File("ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (device.equalsIgnoreCase("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
		}

		else if (device.equalsIgnoreCase("real")) {
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LenovoTAB");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
			

		}
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;

	}

}
