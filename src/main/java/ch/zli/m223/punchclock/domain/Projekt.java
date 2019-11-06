package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Kunde customer;

    @OneToMany(mappedBy = "project")
    private List<Stunden> hour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kunde getCustomer() {
        return customer;
    }

    public void setCustomer(Kunde customer) {
        this.customer = customer;
    }

    public List<Stunden> getHour() {
        return hour;
    }

    public void setHour(List<Stunden> hour) {
        this.hour = hour;
    }
}
