package com.burak.service;


import com.burak.dto.request.ProductSaveRequestDto;
import com.burak.dto.request.ProductUpdateRequestDto;
import com.burak.dto.request.StockSaveRequestDto;
import com.burak.dto.request.StockUpdateRequestDto;
import com.burak.exception.ErrorType;
import com.burak.exception.ProductServiceException;
import com.burak.manager.StockManager;
import com.burak.repository.IProductRepository;
import com.burak.repository.entity.Product;
import com.burak.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private final IProductRepository iProductRepository;
    private final StockManager stockManager;

    public ProductService(IProductRepository iProductRepository, StockManager stockManager) {
        super(iProductRepository);
        this.iProductRepository = iProductRepository;
        this.stockManager = stockManager;
    }
    public Boolean save(ProductSaveRequestDto productSaveRequestDto) {
        Product product = Product.builder()
                .productName(productSaveRequestDto.getProductName())
                .productNumber(productSaveRequestDto.getProductNumber())
                .build();
        save(product);
        if(product.getId() != null){
            stockManager.save(StockSaveRequestDto.builder()
                            .productId(product.getId())
                            .productNumber(product.getProductNumber())
                    .build());
            return true;
        }

        return false;
    }

    public Boolean update(ProductUpdateRequestDto productUpdateRequestDto) {

        Optional<Product> product = iProductRepository.findOptinalById(productUpdateRequestDto.getProductId());

        if(product.isEmpty()) throw new ProductServiceException(ErrorType.PRODUCT_NOT_FOUND);

        Product product1 = product.get();

        product1.setProductName(productUpdateRequestDto.getProductName());
        product1.setProductNumber(productUpdateRequestDto.getProductNumber());
        product1.setUpdateDate(LocalDate.now());
        product1.setStockId(productUpdateRequestDto.getStockId());

        save(product1);
        if(product1.getId() !=null) {
            stockManager.update(
                    StockUpdateRequestDto.builder()
                            .updateDate(product1.getUpdateDate())
                            .productNumber(product1.getProductNumber())
                            .productId(product1.getId())
                            .build());
            return true;

        }
        return false;


    }
    public Product findByProductName(String productName) {
        Optional<Product> product = iProductRepository.findOptinalByProductName(productName);
        if (product.isPresent()){
            return product.get();
        }else{
            throw new ProductServiceException(ErrorType.PRODUCT_NOT_FOUND);
        }
    }


}
