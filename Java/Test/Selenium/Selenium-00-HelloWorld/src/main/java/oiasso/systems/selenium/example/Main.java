package oiasso.systems.selenium.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromeOptions.addArguments(new String[] { "--headless" });
		chromeOptions.addArguments(new String[] { "--start-maximized" });
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		ChromeDriverService driverService = ChromeDriverService.createDefaultService();
		 WebDriver driver = (WebDriver) new ChromeDriver(driverService, chromeOptions);
		
		driver.get("http://www.google.es");

		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
		Date date = new Date();
		
		for (int i = 0; i < 10; i++) {

			File myScreenshot = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(myScreenshot,
						new File("screenshots/Foto-" + dateFormat.format(date) + i +  ".png"));
			} catch (IOException e) {
//				LOGGER.error(e);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		driver.manage().deleteAllCookies();
		driver.quit();

		
		
		

	}

}
