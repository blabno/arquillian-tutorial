package pl.itcrowd.tutorials.arquillian.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.itcrowd.tutorials.arquillian.TransactionDelegate;
import pl.itcrowd.tutorials.arquillian.TransactionFun;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRequiredException;

@RunWith(Arquillian.class)
public class TransactionFunTest {

    @EJB
    private TransactionFun fun;

    @Deployment
    public static JavaArchive createDeployment()
    {
        // explicit archive name required until ARQ-77 is resolved
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(TransactionFun.class, MandatoryDelegate.class, TransactionDelegate.class);
    }

    @Test(expected = EJBTransactionRequiredException.class)
    public void transactionNotSupported()
    {
        //        Given

        //        When
        fun.transactionNotSupported();
    }

    @Test
    public void transactionRequired()
    {
        //        Given

        //        When
        fun.transactionRequired();
    }
}