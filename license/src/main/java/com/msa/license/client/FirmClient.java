package com.msa.license.client;

import com.msa.license.client.dto.FirmDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="firm")
public interface FirmClient {

    @GetMapping("/firm")
    List<FirmDto> getAllFirms();

    @GetMapping("/firm/{firmId}")
    

}
