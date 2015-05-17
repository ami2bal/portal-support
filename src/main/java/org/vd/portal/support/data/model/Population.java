package org.vd.portal.support.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<Prestation> prestationList = new ArrayList<>();

    @OneToMany
    private List<Role> roleList = new ArrayList<>();

    @OneToMany
    private List<Category> categoryList = new ArrayList<>();

    /**
     * Constructor
     */
    protected Population() {
    }

    /**
     * Constructor
     *
     * @param name
     */
    public Population(String name) {
        this.name = name;
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

    public List<Prestation> getPrestationList() {
        return prestationList;
    }

    public void setPrestationList(List<Prestation> prestationList) {
        this.prestationList = prestationList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Population{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prestationList=" + prestationList +
                ", roleList=" + roleList +
                ", categoryList=" + categoryList +
                '}';
    }
}