package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I have entered Grolls site")
	public void i_have_entered_grolls_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver(); // Starta chrome
		driver.manage().window().maximize();
		driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
	}

	@Given("I have picked size")
	public void i_have_picked_size() throws InterruptedException {
		Select dropDown = new Select(driver.findElement(By.name("super_attribute[400]")));
		Thread.sleep(3000);
		// dropDown.selectByValue("1419");
		dropDown.selectByIndex(3);
		Thread.sleep(3000);
	}

	@Given("I have also selected two shirts")
	public void i_have_also_selected_two_shirts() {
		WebElement button = driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div/div/div[1]/div/div/span[2]"));
		button.click();
	}

	@When("I press add to basket")
	public void i_press_add_to_basket() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		button.click();
		Thread.sleep(3000);
	}

	@Then("the result should be {int} shirts in basket")
	public void the_result_should_be_shirts_in_basket(Integer int1) throws InterruptedException {
		WebElement answer = driver.findElement(By.xpath("/html/body/div[4]/header/div[3]/div[4]/a/span/span[1]"));
		answer.getAttribute("textContent");
		assertEquals("2", answer.getAttribute("textContent"));
		driver.quit();
	}

}
