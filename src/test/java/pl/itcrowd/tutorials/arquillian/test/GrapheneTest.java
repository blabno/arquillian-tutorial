package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class GrapheneTest {

    @Page
    AutocompletePage autocompletePage;

    @Drone
    WebDriver driver;

    @Page
    ShowcasePage showcasePage;

    @Test
    public void someTest()
    {
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://showcase.richfaces.org/");
        showcasePage.clickInputsTab();
        showcasePage.clickAutoCompleteMenuItem();
        assertEquals("http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=autocomplete&skin=blueSky", driver.getCurrentUrl());
        final List<WebElement> suggestions = autocompletePage.typeIntoFirstAutocomplete("al");
        assertEquals(2, suggestions.size());
        assertEquals("Alabama", suggestions.get(0).getText());
        assertEquals("Alaska", suggestions.get(1).getText());
    }
}
