package pl.itcrowd.tutorials.arquillian;

import javax.ejb.Stateless;

@Stateless
public class Echo {

    public String echo(String message)
    {
        return message;
    }
}
