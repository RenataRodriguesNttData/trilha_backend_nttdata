package br.com.financys.entities;

import javax.persistence.*;

@Table(name = "category")
@Entity
public class Category<String> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

        System.out.printf("As informações são = %s ", this);
    }

    public Category() {

    }

    public java.lang.String toString() {
        return "id:" + id + "name: " + name + "description: " + description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
