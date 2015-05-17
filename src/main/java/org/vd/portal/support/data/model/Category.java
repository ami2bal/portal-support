package org.vd.portal.support.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    private int suggestionsCount;

    @OneToMany
    private List<Suggestion> suggestionList = new ArrayList<>();

    /**
     * Constructor
     */
    protected Category() {
    }

    /**
     * Constructor
     *
     * @param name
     */
    public Category(String name) {
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

    public int getSuggestionsCount() {
        return suggestionList.size();
    }

    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suggestionList=" + suggestionList +
                '}';
    }
}