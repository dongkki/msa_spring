package com.msa.license.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicenseWithFirmDto {
    private Long licenseId;
    private String licenseName;
    private LocalDate createdDate;

    private Long firmId;
    private String firmName;
    private LocalDate foundedDate;
}
