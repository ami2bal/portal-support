package org.vd.portal.support.data.model;

import javax.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String reponse;

    @ManyToOne
    private Category category;

    /**
     * Constructor
     */
    protected Suggestion() {
    }

    /**
     * Constructor
     *
     * @param question
     * @param reponse
     * @param category
     */
    public Suggestion(String question, String reponse, Category category) {
        this.question = question;
        this.reponse = reponse;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", category=" + category +
                '}';
    }
}