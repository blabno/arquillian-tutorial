package pl.itcrowd.tutorials.arquillian.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class ShowcasePage {

    @FindBy(xpath = "//*[@class='rf-pm']//*[@class='rf-pm-itm-lbl'][text()='rich:autocomplete']")
    private WebElement autoCompleteMenuItem;

    @FindBy(xpath = "//*[@class='rf-pm']//*[@class='rf-pm-top-gr-lbl'][text()='Inputs']")
    private WebElement inputsTab;

    public void clickAutoCompleteMenuItem()
    {
        guardHttp(autoCompleteMenuItem).click();
    }

    public void clickInputsTab()
    {
        inputsTab.click();
    }
}
