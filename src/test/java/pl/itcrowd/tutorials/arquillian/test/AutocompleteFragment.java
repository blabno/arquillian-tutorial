package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.graphene.spi.annotations.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class AutocompleteFragment {

    @FindBy(className = "rf-au-inp")
    WebElement input;

    @FindBy(className = "rf-au-itm")
    List<WebElement> listItems;

    @Root
    WebElement root;

    public List<WebElement> getSuggestions()
    {
        return getSuggestionList().findElements(By.className("rf-au-itm"));
    }

    public List<WebElement> type(String msg)
    {
        input.sendKeys(msg);
        try {
            Graphene.waitGui().until().element(getSuggestionList()).is().visible();
            return getSuggestions();
        } catch (TimeoutException e) {
            return Collections.emptyList();
        }
    }

    private WebElement getSuggestionList()
    {
        String id = root.getAttribute("id") + "List";
        return root.findElement(By.xpath("//body")).findElement(By.id(id));
    }
}
