package pl.itcrowd.tutorials.arquillian;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Echo {

    @PersistenceContext
    private EntityManager entityManager;

    public String echo(String message)
    {
        entityManager.persist(new Message(message));
        return message;
    }
}
