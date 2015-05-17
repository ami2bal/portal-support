package org.vd.portal.support.data.model;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Population population;

    /**
     * Constructor
     */
    protected Role() {
    }

    /**
     * Constructor
     *
     * @param name
     * @param population
     */
    public Role(String name, Population population) {
        this.name = name;
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

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}