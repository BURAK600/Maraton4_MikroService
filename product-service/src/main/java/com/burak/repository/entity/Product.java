package com.burak.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tblproduct")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stockId;
    private Long productNumber;
    private String productName;
    @Builder.Default
    private LocalDate createDate=LocalDate.now();

    private LocalDate updateDate;






}
