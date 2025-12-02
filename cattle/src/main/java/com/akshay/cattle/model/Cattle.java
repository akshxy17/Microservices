package com.akshay.cattle.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cattle {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cows;

    @Column(nullable = false)
    private int goats;

    @Column(nullable = false)
    private int sheeps;

    @Column(nullable = false)
    private int buffaloes;

    private Long farmerId;


}
