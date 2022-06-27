package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaGetOfferPage {

    public CarvanaGetOfferPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "div[class*='kjoUgV']")
    public WebElement errorMessage;
}
