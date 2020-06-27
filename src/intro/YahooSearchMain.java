package intro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class YahooSearchMain {


	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
		WebDriver driver;
		driver = new ChromeDriver(); // aqui se utiliza el browser que yo elija
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get("http://www.yahoo.com"); //navega a la url que le indiquemos
		WebElement searchBox = driver.findElement(By.id("header-search-input"));
		WebElement searchButton = driver.findElement(By.id("header-desktop-search-button"));
		
		searchBox.clear();
		searchBox.sendKeys("Selenium");
		searchButton.click();
		
		WebElement seleniumLink = driver.findElement(By.xpath("//h3[.='Selenium' and ./following-siblings: :div[contains(.,'selenium.dev')] ] /a"));
		seleniumLink.click();
		
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of windows: " + windowIds.size());
		
		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}
		
		WebElement downloadLink = driver.findElement(By.linkText("Downloads"));
		downloadLink.click();
		
		driver.close();

	}

}
