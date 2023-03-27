package com.musala.javatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class medication {
    @Id
    private Long id;
    private String name;
    private BigDecimal weight;
    private String code;
    private String imageUrl;
}
