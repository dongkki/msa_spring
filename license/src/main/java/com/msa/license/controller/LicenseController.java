package com.msa.license.controller;

import com.msa.license.domain.License;
import com.msa.license.dto.LicenseWithFirmDto;
import com.msa.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("license")
@RequiredArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;

    @GetMapping("/withFrim")
    public ResponseEntity<List<LicenseWithFirmDto>> getAllLicenseWithFirm() {
        return ResponseEntity.ok(licenseService.getAllLicenseWithFirms());
    }

    @GetMapping("/{licenseId}/withFirm")
    public ResponseEntity<LicenseWithFirmDto> getLicenseWithFirm(@PathVariable Long licenseId) {
        return ResponseEntity.ok(licenseService.getLicenseWithFirm(licenseId));
    }

    @GetMapping("/withFrim/{firmId}")
    public ResponseEntity<List<LicenseWithFirmDto>> getLicenseByFirm(@PathVariable Long firmId) {
        return ResponseEntity.ok(licenseService.getLicenseByFirm(firmId));
    }

    @GetMapping
    public ResponseEntity<List<License>> getAllLicenses() {
        return ResponseEntity.ok(licenseService.getAllLicenses());
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable Long licenseId) {
        return ResponseEntity.ok(licenseService.getLicense(licenseId));
    }

    @PostMapping
    public ResponseEntity<License> createLicense(@RequestBody License license) {
        License create = licenseService.createLicense(license);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{licenseId}")
    public ResponseEntity<License> updateLicense(@PathVariable Long licenseId, @RequestBody License updateLicense) {
        return ResponseEntity.ok(licenseService.updateLicense(licenseId, updateLicense));
    }

    @DeleteMapping("/{licenseId}")
    public ResponseEntity<License> deleteLicense(@PathVariable Long licenseId) {
        licenseService.deleteLicense(licenseId);
        return ResponseEntity.noContent().build();
    }

}