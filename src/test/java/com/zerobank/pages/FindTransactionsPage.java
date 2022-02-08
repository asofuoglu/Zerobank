package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FindTransactionsPage {
    public FindTransactionsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

    @FindBy(xpath = "//button[text()='Find']")
    public  WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dateOrder;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']/tbody/tr/td")
    public List<WebElement> descriptionList;

    @FindBy(css = "div.well")
    public WebElement noResultText;

    @FindBy(xpath = "//td[contains(text(),'2012')]/following-sibling::td[2]")
    public List<WebElement> depositList;

    @FindBy(xpath = "//td[contains(text(),'2012')]/following-sibling::td[3]")
    public List<WebElement> withdrawList;

    @FindBy(id = "aa_type")
    public WebElement selectType;

    public boolean NoResultUnderDeposit() {
        boolean verify=true;
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement element : depositList) {
            list.add(element.getText());
            if(!element.getText().equals(""))
                verify=false;
        }
       return verify;
    }
    public boolean NoResultUnderWithdrawal() {
        boolean verify=true;
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement element : withdrawList) {
            list.add(element.getText());
            System.out.println(element.getText());
            if(!element.getText().equals(""))
                verify=false;
        }
        return verify;
    }
    public boolean OneResultUnderDeposit() throws InterruptedException {
        Thread.sleep(1000);
        boolean verify=false;
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement element :depositList) {
            list.add(element.getText());
            if(!element.getText().equals(" "))
                verify=true;
     }
        return verify;
    }
    public boolean OneResultUnderWithdrawal() throws InterruptedException {
        Thread.sleep(1000);
        boolean verify=false;
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement element : withdrawList) {
            list.add(element.getText());
            if(!element.getText().equals(""))
                verify=true;
        }
        return verify;
    }
    public boolean OnlyShowDescriptionsContaining(String str) {
        Boolean verify=true;
        String key=" ";
        if(str.equals("ONLINE"))
            key="OFFLINE";
        else if(str.equals("OFFLINE"))
            key="ONLINE";
        for (WebElement element : descriptionList) {
            if(element.getText().contains(key))
                verify=false;
        }
       return verify;
    }
    public boolean OnlyShowDescriptionsContainingOFFICE() {
        Boolean verify=true;
        for (WebElement element :descriptionList) {
            if(element.getText().contains("ONLINE"))
                verify=false;
        }
        return verify;
    }
    public boolean OnlyShowDescriptionsContainingONLINE() {
        Boolean verify=true;
        for (WebElement element : descriptionList) {
            if(element.getText().contains("OFFLINE"))
                verify=false;
        }
        return verify;
    }
    public void showDatesBetweenTo(String str1, String str2) throws InterruptedException {
        Thread.sleep(1000);
        List<String> date = BrowserUtils.getElementsText(dateOrder);
        Assert.assertEquals(date.get(0),"2012-09-06");
        Assert.assertEquals(date.get(date.size()-1),"2012-09-01");
    }
    public void sortedResutlMostDated() throws InterruptedException {// without DATE class
        Thread.sleep(1000);
        ArrayList<String> date = new ArrayList<String>(); // Create an ArrayList object
        ArrayList<Integer> Intdate = new ArrayList<Integer>();
        ArrayList<Integer> unsort = new ArrayList<Integer>();
        for (WebElement element :dateOrder) {
            if(element.getText().startsWith("2012")){
                date.add(element.getText());
                Intdate.add(Integer.parseInt(element.getText().substring(7)));
            }
        }
        unsort=Intdate;
        Collections.sort(Intdate);
        Assert.assertTrue(Intdate.equals(unsort));
    }

    public boolean sortedMostDated() throws InterruptedException, ParseException {//with DATE class
        Thread.sleep(1000);
        boolean verify= false;
        List<String> stringDates = BrowserUtils.getElementsText(dateOrder);

        List<Date> dates = new ArrayList<Date>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String element : stringDates) {
            dates.add(new SimpleDateFormat("yyyy/MM/dd").parse(element.replaceAll("-","/")));
        }
        List<Date> sorted = dates.stream()
                .sorted(Comparator.comparingLong(Date::getTime))
                .collect(Collectors.toList());
        List<String> stringSortedDates = new ArrayList<String>();
        for (Date element : sorted) {
            stringSortedDates.add(dateFormat.format(element)) ;
        }
        verify=stringDates.equals(stringSortedDates);
        return verify;
    }
        public boolean notContainDate(String str1) throws InterruptedException {
            Thread.sleep(2000);
        List<String> date = BrowserUtils.getElementsText(dateOrder);
            System.out.println(date.toString());
        boolean verify=true;
        if (date.contains(str1))
            verify=false;
            return verify;
    }
    public void entersDateRangeFromTo(String str1, String str2) throws InterruptedException {
        fromDateInput.clear();
        toDateInput.clear();
        fromDateInput.sendKeys(str1);
        toDateInput.sendKeys(str2);
        findButton.click();
    }
    public void selectType(String str) {
        Select typeDropdown = new Select(selectType);
        typeDropdown.selectByVisibleText(str);
        findButton.click();
    }
    public void entersDescription(String str) {
        descriptionInput.clear();
        descriptionInput.sendKeys(str);
        findButton.click();
    }
}




