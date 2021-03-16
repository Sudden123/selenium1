package stepDefinitions;

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

	@Given("I am logged in")
	public void i_am_logged_in() {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver(); // Starta chrome
		driver.manage().window().maximize();
		driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");

	}

	@Given("I have entered {int} into the calculator")
	public void i_have_entered_into_the_calculator(Integer int1) {
		WebElement numOne = driver.findElement(By.name("n01"));
		numOne.sendKeys("50");

	}

	@Given("I have also entered {int} into the calculator")
	public void i_have_also_entered_into_the_calculator(Integer int1) {
		WebElement numTwo = driver.findElement(By.name("n02"));
		numTwo.sendKeys("50");
	}

	@When("I use add")
	public void i_use_add() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
		button.click();
		
	}

	@Then("the result should be {int} on the screen")
	public void the_result_should_be_on_the_screen(Integer int1) {
		WebElement answer = driver.findElement(By.name("answer"));
		answer.getText();
		assertEquals("100", answer.getText());
		driver.quit();
	}

}
