package com.burak.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductUpdateRequestDto {

    private Long productId;
    private Long stockId;
    private Long productNumber;
    private String productName;
    @Builder.Default
    private LocalDate updateDate = LocalDate.now();
}
