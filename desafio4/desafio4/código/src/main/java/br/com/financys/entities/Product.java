package br.com.financys.entities;

public class Product {
    long id;
    String name;
    String description;
    double price;

    public Product() {

    }

    public Product(long id, String n, String d, double p) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public String toString() {
        return String.format("%d\\%s\\%s\\%d", id, name, description, price);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
