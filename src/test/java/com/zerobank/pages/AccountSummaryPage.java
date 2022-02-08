package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    AccountActivityPage accountActivityPage = new AccountActivityPage();
   @FindBy(xpath = "//h2[@class='board-header']")
   public List<WebElement> accountTypes;

    @FindBy(xpath = "//th[text()='Credit Card']/../th")
    public List<WebElement> CreditAccountsColmn;

    public void selectDropdownLink(String link){
        for (WebElement element : accountActivityPage.accountTableLink) {
            if(element.getText().equals(link)){
                element.click();
                break;}
        }
    }
    public List<String> getActualAccountTypes(){
        return BrowserUtils.getElementsText(accountTypes);
    }
    public List<String> getActualColumns(){
        return BrowserUtils.getElementsText(CreditAccountsColmn);
    }
}
