package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.ajocado.dom.Event;
import org.jboss.arquillian.ajocado.framework.GrapheneSelenium;
import org.jboss.arquillian.ajocado.locator.IdLocator;
import org.jboss.arquillian.ajocado.locator.JQueryLocator;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;

import static org.jboss.arquillian.ajocado.Graphene.guardHttp;
import static org.jboss.arquillian.ajocado.Graphene.guardXhr;
import static org.jboss.arquillian.ajocado.Graphene.id;
import static org.jboss.arquillian.ajocado.Graphene.jq;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class GrapheneTest {

    @Drone
    GrapheneSelenium browser;

    URL url;

    public GrapheneTest() throws MalformedURLException
    {
        url = new URL("http://showcase.richfaces.org/");
    }

    @Test
    public void autocomplete()
    {
//        Given
        browser.open(url);

//        When
        browser.click(jq(".rf-pm .rf-pm-top-gr-lbl:contains('Input')"));
        guardHttp(browser).click(jq(".rf-pm .rf-pm-itm-lbl:contains('rich:autocomplete')"));

        final IdLocator input = id("j_idt426:j_idt427Input");
        browser.focus(input);
        browser.type(input, "al");
        guardXhr(browser).fireEvent(input, Event.KEYPRESS);

//        Then
        final JQueryLocator child = jq("#j_idt426\\:j_idt427List .rf-au-itm");
        assertEquals(2, child.size());
    }
}
