package com.burak.manager;


import com.burak.dto.request.StockSaveRequestDto;
import com.burak.dto.request.StockUpdateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.burak.constants.ApiUrls.SAVE;
import static com.burak.constants.ApiUrls.UPDATE;

@FeignClient(name = "stock-service", url = "http://localhost:9088/api/v1/stock", decode404 = true)
public interface StockManager {

    @PostMapping(UPDATE)

    ResponseEntity<Boolean> update(@RequestBody StockUpdateRequestDto stockUpdateRequestDto);
    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto stockSaveRequestDto);
}
