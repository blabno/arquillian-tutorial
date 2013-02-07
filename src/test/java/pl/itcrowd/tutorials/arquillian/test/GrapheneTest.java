package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class GrapheneTest {

    final String AUTOCOMPLETE_ID = "j_idt426:j_idt427";

    final String AUTOCOMPLETE_LIST_ID = AUTOCOMPLETE_ID + "List";

    @Drone
    WebDriver driver;

    @Test
    public void someTest()
    {
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://showcase.richfaces.org/");
        final WebElement inputsTab = driver.findElement(By.xpath("//*[@class='rf-pm']//*[@class='rf-pm-top-gr-lbl'][text()='Inputs']"));
        final WebElement autoComplete = driver.findElement(By.xpath("//*[@class='rf-pm']//*[@class='rf-pm-itm-lbl'][text()='rich:autocomplete']"));
        inputsTab.click();
        autoComplete.click();
        assertEquals("http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=autocomplete&skin=blueSky", driver.getCurrentUrl());
        final WebElement autocomplete = driver.findElement(By.id(AUTOCOMPLETE_ID));
        final WebElement autocompleteList = driver.findElement(By.id(AUTOCOMPLETE_LIST_ID));
        final WebElement input = autocomplete.findElement(By.className("rf-au-inp"));
        input.sendKeys("al");
//        Graphene.waitGui(driver).until(Graphene.element(autocompleteList).isVisible());
        Graphene.waitGui(driver).until().element(autocompleteList).is().visible();
        final List<WebElement> sugestions = autocompleteList.findElements(By.className("rf-au-itm"));
        assertEquals(2, sugestions.size());
        assertEquals("Alabama", sugestions.get(0).getText());
        assertEquals("Alaska", sugestions.get(1).getText());
    }
}
