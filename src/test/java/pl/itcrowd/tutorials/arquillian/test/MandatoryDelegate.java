package pl.itcrowd.tutorials.arquillian.test;

import pl.itcrowd.tutorials.arquillian.TransactionDelegate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class MandatoryDelegate implements TransactionDelegate {

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @Override
    public void haveFun()
    {

    }
}
