package com.example.gameshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameRegisterDto {
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+\\{3,100}", message = "Title is not valid")
    private String title;

    @DecimalMin(value = "0")
    private BigDecimal price;

    @Min(0)
    private double size;

    @Length(max = 11)
    private String trailer;

    @URL()
    private String thumbnailURL;

    @Length(min = 20)
    private String description;

    private LocalDate releaseDate;
}
