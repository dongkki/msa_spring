package com.msa.license.service;

import com.msa.license.client.FirmClient;
import com.msa.license.client.dto.FirmDto;
import com.msa.license.domain.License;
import com.msa.license.dto.LicenseWithFirmDto;
import com.msa.license.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LicenseService {
    private final LicenseRepository licenseRepository;
    private final FirmClient firmClient;

    public LicenseWithFirmDto getLicenseWithFirm(Long licenseId) {
        License license = licenseRepository.findById(licenseId).orElse(null);
        FirmDto firm = firmClient.getFirmById(license.getFirmId());
        return convertToDto(license, firm);
    }

    public List<LicenseWithFirmDto> getLicenseByFirm(Long firmId) {
        FirmDto firmDto = firmClient.getFirmById(firmId);
        List<License>  licenseList = licenseRepository.findByFirmId(firmDto.getFirmId());
        return licenseList.stream()
                .map(license -> convertToDto(license, firmDto))
                .collect(Collectors.toList());
    }

    public List<LicenseWithFirmDto> getAllLicenseWithFirms() {
        List<License> licenseList = licenseRepository.findAll();
        return licenseList.stream()
                .map(license -> {
                    FirmDto firmDto = firmClient.getFirmById(license.getFirmId());
                    return convertToDto(license, firmDto);
                }).collect(Collectors.toList());
    }

    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    public License getLicense(Long licenseId) {
        return licenseRepository.findById(licenseId).orElse(null);
    }

    @Transactional
    public License createLicense(License license) {
        return licenseRepository.save(license);
    }

    @Transactional
    public License updateLicense(Long licenseId, License updateLicense) {
        License license = getLicense(licenseId);
        license.setLicenseName(updateLicense.getLicenseName());
        license.setFirmId(updateLicense.getFirmId());

        return licenseRepository.save(license);
    }

    @Transactional
    public void deleteLicense(Long licenseId) {
        licenseRepository.deleteById(licenseId);
    }

    private LicenseWithFirmDto convertToDto(License license, FirmDto firmDto) {
        LicenseWithFirmDto licenseWithFirmDto = new LicenseWithFirmDto();
        licenseWithFirmDto.setLicenseId(license.getLicenseId());
        licenseWithFirmDto.setLicenseName(license.getLicenseName());
        licenseWithFirmDto.setCreatedDate(license.getCreatedDate());
        licenseWithFirmDto.setFirmId(firmDto.getFirmId());
        licenseWithFirmDto.setFirmDto(firmDto);

        return licenseWithFirmDto;
    }

}