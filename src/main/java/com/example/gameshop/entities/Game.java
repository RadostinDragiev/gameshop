package com.example.gameshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    private double size;

    private String trailer;

    @Column(name = "thumbnail_url")
    private String thumbnailURL;

    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;
}
