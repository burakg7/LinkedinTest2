package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GooglePage;
import pages.LinkedinLoginPage;
import utils.ConfigUtil;
public class LinkedinValidationSteps {

    WebDriver driver;
    GooglePage googlePage;
    LinkedinLoginPage linkedinLoginPage;

    @Given("User goes to google")
    public void userGoesToGoogle() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        googlePage = new GooglePage(driver);
        linkedinLoginPage = new LinkedinLoginPage(driver);
        driver.get(ConfigUtil.getProperty("googleURL"));
    }

    @And("User searches the {string} on google")
    public void userSearchesTheOnGoogle(String searchKey) {
        googlePage.sendKeysToGoogleSearch(searchKey);
    }

    @When("User clicks the {string} Page")
    public void userClicksThePage(String relatedKeyword)  {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+relatedKeyword + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @And("User logins to Linkedin")
    public void userLoginsToLinkedin() {
        linkedinLoginPage.loginToLinkedin(ConfigUtil.getProperty("linkedinUserName"),ConfigUtil.getProperty("linkedinPassword"));
    }

    @Then("User Validates the {string} on Linkedin")
    public void userValidatesTheOnLinkedin(String validationKeyword){
        Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'" + validationKeyword + "')]")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
