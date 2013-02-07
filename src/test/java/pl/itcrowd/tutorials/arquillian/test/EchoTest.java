package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.tutorials.arquillian.Echo;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class EchoTest {

    @EJB
    private Echo echo;

    @Deployment
    public static JavaArchive createDeployment()
    {
        // explicit archive name required until ARQ-77 is resolved
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(Echo.class);
    }

    @Test
    public void testEcho()
    {
//        Given
        final String message = "Jack";

//        When
        final String result = echo.echo(message);

//        Then
        assertEquals(message, result);
    }
}
