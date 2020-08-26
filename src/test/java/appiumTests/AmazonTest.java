package appiumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonTest {

	static AppiumDriver<MobileElement> driver;

	@Test
	public static void setCapabilities() throws MalformedURLException, InterruptedException {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			System.out.println("Applicartion Started....");

			cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM J710F");
//			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");

			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);

			System.out.println("Applicartion Launched....");
			Thread.sleep(5000);
				WebElement selectLanguage = driver.findElementByXPath("//android.widget.GridLayout/android.widget.ImageView[1]");
				selectLanguage.click();
				driver.findElementById("in.amazon.mShop.android.shopping:id/sign_in_button").click();
				
//				driver.findElementByXPath("//android.widget.Button[@content-desc=\"Sign in or create\"]/android.view.ViewGroup[2]/android.widget.TextView").click();
	
				driver.findElementById("in.amazon.mShop.android.shopping:id/rs_search_src_text").click();
				driver.findElementById("in.amazon.mShop.android.shopping:id/rs_search_src_text").sendKeys("iPhone below 85000");
				cap.setCapability("unicodeKeyboard", "true");                                     
				cap.setCapability("resetKeyboard", "true");
				
				driver.findElementByXPath("//android.view.View[contains(@content-desc,'Apple iPhone 11 (64GB) - Black 4.5']").click();
				
//				driver.findElementById("com.sec.android.app.popupcalculator:id/bt_equal").click();
//	
//				Thread.sleep(5000);	
//				System.out.println(driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc").getText());
//				String result = driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc").getText();
//				System.out.println(result);
//				
//				if(result.equals("10"))
//					System.out.println("Test Passed......");
//				else
//					System.out.println("Test Failes......");

		} catch (MalformedURLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
