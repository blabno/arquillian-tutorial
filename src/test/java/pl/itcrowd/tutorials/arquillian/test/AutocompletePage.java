package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutocompletePage {

    final String AUTOCOMPLETE_ID = "j_idt426:j_idt427";

    final String AUTOCOMPLETE_LIST_ID = AUTOCOMPLETE_ID + "List";

    @FindBy(id = AUTOCOMPLETE_ID)
    private AutocompleteFragment firstAutocomplete;

    public List<WebElement> typeIntoFirstAutocomplete(String msg)
    {
        return firstAutocomplete.type(msg);
    }
}
