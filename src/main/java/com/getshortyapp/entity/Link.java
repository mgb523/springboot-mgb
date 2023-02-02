package com.getshortyapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="curated")
    private String curated;

    public void setCurated(String curatedLink) {
        this.curated = curatedLink;
    }

    @Column(name="shortened")
    private String shortened;

    @Column(name="count")
    private int count;
}
