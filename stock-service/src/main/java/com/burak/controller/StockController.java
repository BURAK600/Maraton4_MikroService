package com.burak.controller;

import com.burak.dto.request.StockSaveRequestDto;
import com.burak.dto.request.StockUpdateRequestDto;
import com.burak.repository.entity.Stock;
import com.burak.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burak.constants.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(STOCK)
public class StockController {
    private final StockService stockService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto stockSaveRequestDto){
        return ResponseEntity.ok(stockService.save(stockSaveRequestDto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody StockUpdateRequestDto stockUpdateRequestDto){
        return ResponseEntity.ok(stockService.update(stockUpdateRequestDto));
    }

    @GetMapping(FIND_BY_PRODUCT_ID)
    public ResponseEntity<Stock> getStockNumber(Long productId){
        return ResponseEntity.ok(stockService.getStock(productId));

    }

    @GetMapping(STOCK_LIST)
    public ResponseEntity<List<Stock>>  findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }



}
