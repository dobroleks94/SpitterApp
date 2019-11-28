package springapp.spittr.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Spittle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="message")
    private String message;

    @Column(name = "time")
    private  Date time;

    @ManyToOne(targetEntity = Spitter.class)
    @JoinColumn(name = "spittle_id")
    private Spitter spitter;


    public Spittle(){}

    public Spittle(String message, Date time, Spitter spitter) {
        this(null, message, time, spitter);
    }
    public Spittle(Long id, String message, Date time, Spitter spitter) {
        this.id = id;
        this.message=message;
        this.time=time;
        this.spitter = spitter;
    }

    public Long getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Date getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
       return EqualsBuilder.reflectionEquals(this, o, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }
}
