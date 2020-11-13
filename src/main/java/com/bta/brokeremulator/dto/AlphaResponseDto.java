package com.bta.brokeremulator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class AlphaResponseDto {
    private String value;
}
