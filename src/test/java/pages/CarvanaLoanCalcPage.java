package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaLoanCalcPage {
    public CarvanaLoanCalcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement priceInputBox;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropdown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermDropDown;

    @FindBy(css = "div[class='loan-calculator-display-value']")
    public WebElement loanCalculatorResult;
}
