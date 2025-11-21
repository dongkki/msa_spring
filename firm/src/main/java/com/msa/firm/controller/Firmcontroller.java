package com.msa.firm.controller;

import com.msa.firm.domain.Firm;
import com.msa.firm.service.Firmservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/firm")
@RequiredArgsConstructor
public class Firmcontroller {
    private final Firmservice firmservice;

    @GetMapping
    public ResponseEntity<List<Firm>> getAllFirms (){
        return ResponseEntity.ok(firmservice.findAll());
    }

    @GetMapping("/{firmId}")
    public ResponseEntity<Firm> getFirm (@PathVariable Long firmId){
        return ResponseEntity.ok(firmservice.findById(firmId));
    }

    @PostMapping
    public ResponseEntity<Firm> createFirm (@RequestBody Firm firm){
        Firm createFirm = firmservice.create(firm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createFirm);
    }

    @PutMapping("/{firmId}")
    public ResponseEntity<Firm> updateFirm (@PathVariable Long firmId, @RequestBody Firm firm){
        Firm updateFirm = firmservice.update(firmId, firm);
        return ResponseEntity.ok(updateFirm);
    }

    @DeleteMapping("/{firmId}")
    public ResponseEntity<Firm> deleteFirm (@PathVariable Long firmId){
        firmservice.deleteById(firmId);
        return ResponseEntity.noContent().build();
    }

}
