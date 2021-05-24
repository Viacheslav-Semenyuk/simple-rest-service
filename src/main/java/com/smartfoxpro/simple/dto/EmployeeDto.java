package com.smartfoxpro.simple.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeDto {

    private Long id;

    private BigDecimal salary;
}
