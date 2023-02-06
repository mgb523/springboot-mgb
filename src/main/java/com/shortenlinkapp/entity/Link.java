package com.shortenlinkapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "links2")
@Access(AccessType.FIELD)
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "curated")
    private String curated;

    public void setCurated(String curatedLink) {
        this.curated = curatedLink;
    }

    public String getCurated() {
        return this.curated;
    }

    @Column(name = "shortened")
    private String shortened;

    public void setShortened(String shortenedLink) {
        this.shortened = shortenedLink;
    }

    public String getShortened() {
        return this.shortened;
    }

    @Column(name = "count")
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
