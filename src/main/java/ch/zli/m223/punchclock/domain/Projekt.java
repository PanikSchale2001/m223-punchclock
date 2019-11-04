package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Kunde customer;
}
