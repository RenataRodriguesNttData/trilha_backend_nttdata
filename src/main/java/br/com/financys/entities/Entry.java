package br.com.financys.entities;


import br.com.financys.dto.EntryDTO;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "ENTRY")
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    private String date;

    @Column(name = "paid")
    private Boolean paid;


    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public Entry() {
    }

    public Entry(Long id, String name, String description, String type, BigDecimal amount, String date, Boolean paid, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.category = category;
    }

    public EntryDTO getId() {
        return new EntryDTO();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Object getCategoryId() {
        return null;
    }

    public void setCategoryId(Object categoryId) {
    }
}





