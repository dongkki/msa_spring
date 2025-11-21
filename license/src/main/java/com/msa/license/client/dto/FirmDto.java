package com.msa.license.client.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirmDto {
    private Long firmId;
    private String firmName;
    private LocalDate foundedDate;
}
