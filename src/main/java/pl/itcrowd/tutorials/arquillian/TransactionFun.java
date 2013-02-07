package pl.itcrowd.tutorials.arquillian;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class TransactionFun {

    @EJB
    private TransactionDelegate delegate;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void transactionNotSupported()
    {
        delegate.haveFun();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void transactionRequired()
    {
        delegate.haveFun();
    }
}
