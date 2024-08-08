package logincondition;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class StepDefinitions {
    WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        // Set up WebDriver and navigate to the login page
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\madis\\OneDrive\\Desktop\\CapstoneProject(ITLearnFramework)\\Drivers\\chromedriver.exe");
       //opens browser
        driver = new ChromeDriver();
        
        driver. manage().window().maximize();
        driver.get("https://www.itlearn360.com/wp-login.php");
        System.out.println("Login page opened");
        
        try {
			Thread.sleep(2);
		} 
        catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // Enter valid credentials
     
    	
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");

		//locate password by name 
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("Abc@123456789@#$%^");
		System.out.println("Entered valid username and password");

		//locate login button
		
        try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        // Enter invalid credentials
    	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Demo12");

		//locate password by name 
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("Te46ee7777376$");
		System.out.println("Entered invalid username and password");
        
        try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

    @Then("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // Click the login button
    	driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
    	System.out.println("Clicked on Login Button");
        try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }


    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();}}}