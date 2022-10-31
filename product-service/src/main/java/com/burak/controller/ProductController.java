package com.burak.controller;

import com.burak.dto.request.ProductSaveRequestDto;
import com.burak.dto.request.ProductUpdateRequestDto;
import com.burak.repository.entity.Product;
import com.burak.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burak.constants.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {

    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody ProductSaveRequestDto productSaveRequestDto){
        return ResponseEntity.ok(productService.save(productSaveRequestDto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return ResponseEntity.ok(productService.update(productUpdateRequestDto));
    }

    @PostMapping(FIND_BY_PRODUCTNAME)
    public ResponseEntity<Product> findByProductName(String userName){
        return ResponseEntity.ok(productService.findByProductName(userName));


    }

    @GetMapping(FINDALL)

    public ResponseEntity<List<Product>> getAll(){

        return ResponseEntity.ok(productService.findAll());
    }




}
