package InstagramFollowBot;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram {

	public static void main(String[] args) throws InterruptedException {
		
		
		int followCount;
		 String username ;
		 String password;
		
		System.out.println("Please keep in mind that Instagram use tools to prevent bots. So please don't enter follow count more than 25. And we are using time to stop instagram blocking the account.");
		System.out.println("How many people you want to follow?");
		Scanner scan= new Scanner(System.in);
		followCount =scan.nextInt();
		
	
		System.out.println("Please enter the username of your instagram?\n");
		 username=scan.next();
	
		
	   System.out.println("\nPlease enter the password of your instagram?\n");
		password=scan.next();
		
	       
		try {
			Thread.sleep(2000);
			
			System.setProperty("webdriver.chrome.driver","/Users/muradnabizade/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.instagram.com/");
			//username
			driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/input[1]")).sendKeys(username);
			//password
			driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/label[1]/input[1]")).sendKeys(password);

			//login click
			driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]")).click();
		
			//save login pop-up
			if(driver.findElement(By.cssSelector("div[class='cmbtv'] button[type='button']")).isEnabled()) {
					driver.findElement(By.cssSelector("div[class='cmbtv'] button[type='button']")).click();
			}
			//notification pop-up
			if (driver.findElement(By.xpath("//button[normalize-space()='Not Now']")).isEnabled()){
				driver.findElement(By.xpath("//button[normalize-space()='Not Now']")).click();
			}
			
			//for loop for follow
			
			for (int i=1; i<=followCount+1;i++) {
				Thread.sleep(1000);
				String s=String.format("(//button[contains(@type,'button')][normalize-space()='Follow'])[%d]",i);  
				driver.findElement(By.xpath(s)).click();
				
			}
		}catch(Exception e) {
			System.out.println("PASSWORD OR USERNAME IS WRONG");
		}
		
		
	
		
	}

}
