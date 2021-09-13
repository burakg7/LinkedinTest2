package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage {

    public LinkedinLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "username")
    public WebElement userNameBox;

    @FindBy (id = "password")
    public WebElement passwordBox;

    @FindBy (className = "btn__primary--large")
    public WebElement signInButton;

    @FindBy (className = "nav__button-secondary")
    public WebElement signInLink;

    public void loginToLinkedin(String userName , String password){
        signInLink.click();
        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        signInButton.click();
    }
}
