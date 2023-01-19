package com.example.gameshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String title;

    private BigDecimal price;

    private int size;

    private String trailer;

    private String thumbnailURL;

    private String description;

    private LocalDate releaseDate;
}
