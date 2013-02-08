package pl.itcrowd.tutorials.arquillian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

    @Id
    @SequenceGenerator(name = "MESSAGE_ID_SEQUENCE", sequenceName = "MESSAGE_ID_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_ID_SEQUENCE")
    private Long id;

    private String text;

    public Message()
    {
    }

    public Message(String message)
    {
        this.text = message;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }

        Message message = (Message) o;

        return !(id != null ? !id.equals(message.id) : message.id != null);
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }
}
