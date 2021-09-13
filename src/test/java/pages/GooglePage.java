package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class GooglePage {
    //POM pattern

    public GooglePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (name = "q")
    public WebElement googleSearchBox;

    @FindBy (className = "CcAdNb")
    public WebElement googleSearchButton;

    public void sendKeysToGoogleSearch(String key){
        googleSearchBox.sendKeys(key + Keys.ENTER);
    }
}
