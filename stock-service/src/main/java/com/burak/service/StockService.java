package com.burak.service;


import com.burak.dto.request.StockSaveRequestDto;
import com.burak.dto.request.StockUpdateRequestDto;
import com.burak.exception.ErrorType;
import com.burak.exception.StockServiceException;
import com.burak.repository.IStockRepository;
import com.burak.repository.entity.Stock;
import com.burak.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StockService extends ServiceManager<Stock, Long> {

    private final IStockRepository iStockRepository;

    public StockService(IStockRepository iStockRepository) {
        super(iStockRepository);
        this.iStockRepository = iStockRepository;
    }

    public Boolean save(StockSaveRequestDto stockSaveRequestDto) {
        Stock stock = save(Stock.builder()
                .productNumber(stockSaveRequestDto.getProductNumber())
                .productId(stockSaveRequestDto.getProductId())
                .build());
        return true;
    }

    public Boolean update(StockUpdateRequestDto stockUpdateRequestDto) {
        Optional<Stock> stock = iStockRepository.findOptionalByProductId(stockUpdateRequestDto.getProductId());
        if (stock.isEmpty()) throw new StockServiceException(ErrorType.PRODUCT_NOT_FOUND);

        Stock stock1 = stock.get();

        stock1.setUpdateDate(LocalDate.now());
        stock1.setProductNumber(stockUpdateRequestDto.getProductNumber());

        save(stock1);
        return true;

    }

    public Stock getStock(Long productId) {
        return iStockRepository.findByProductId(productId);
    }
}
