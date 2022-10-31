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
public class StockUpdateRequestDto {

    private Long productId;
    private Long productNumber;
    private LocalDate updateDate;

}
