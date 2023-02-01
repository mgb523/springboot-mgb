package com.getshortyapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String curated;
    private String shortened;
    private int count;

    public Link(String curated, String shortened, int count) {
        this.setCurated(curated);
        this.setShortened(shortened);
        this.setCount(count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurated() {
        return curated;
    }

    public void setCurated(String curated) {
        this.curated = curated;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
