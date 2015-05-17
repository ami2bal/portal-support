package org.vd.portal.support.data.model;

import javax.persistence.*;

/**
 * Created by bh on 16/05/2015.
 */
@Entity
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    @ManyToOne
    private Population population;

    /**
     * Constructor
     */
    public Prestation() {
    }

    /**
     * Constructor
     *
     * @param name
     * @param population
     */
    public Prestation(String name, Population population) {
        this.name = name;
        this.population = population;
    }

    /**
     * Constructor
     *
     * @param name
     * @param email
     * @param population
     */
    public Prestation(String name, String email, Population population) {
        this.name = name;
        this.email = email;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Prestation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", population=" + population +
                '}';
    }
}
