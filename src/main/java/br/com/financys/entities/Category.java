package br.com.financys.entities;

public class Category {

    private long id;
    private String name;
    private String description;

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

        System.out.printf("As informações são = %s ", this);
    }

    public Category() {

    }

    public String toString() {
        return String.format("%d\\%s\\%s", id, name, description);
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
