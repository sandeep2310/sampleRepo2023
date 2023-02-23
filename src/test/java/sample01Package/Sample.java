package sample01Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("setup done");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		Thread.sleep(3000);
		driver.quit();

	}

}
