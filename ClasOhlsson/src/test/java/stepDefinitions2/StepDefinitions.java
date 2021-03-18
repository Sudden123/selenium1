package stepDefinitions2;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I have entered Clas Ohlsson site")
	public void i_have_entered_clas_ohlsson_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver(); // Starta chrome
		driver.manage().window().maximize();
		driver.get("https://www.clasohlson.com/se/Superlim-Loctite-Precision,-5-g/p/25-1544");
	}

	@Given("I have approved cookies")
	public void i_have_approved_cookies() {

		driver.findElement(By.className("btn-text")).click();

	}

	@Given("I have also added another glue")
	public void i_have_also_added_another_glue() {
		WebElement button = driver.findElement(
				By.xpath("/html/body/main/div[4]/div[1]/div[3]/section[2]/div/div[2]/div[2]/div[2]/div[2]/button[2]"));
		button.click();
	}

	@When("I press add to basket")
	public void i_press_add_to_basket() {
		WebElement button = driver.findElement(
				By.xpath("/html/body/main/div[4]/div[1]/div[3]/section[2]/div/div[2]/div[4]/div[2]/div[2]/button"));
		button.click();
	}

	@Then("the result should be {int} glues in basket")
	public void the_result_should_be_glues_in_basket(Integer int1) throws InterruptedException {
		Thread.sleep(3000);
		WebElement answer = driver.findElement(By
				.xpath("/html/body/main/div[2]/header/nav[1]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/a/div/div[1]"));
		answer.getAttribute("textContent");
		assertEquals("2", answer.getAttribute("textContent"));
		driver.quit();
	}

}
