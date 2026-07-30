package com.nt.dto;

import java.time.LocalDate;

import com.nt.constants.RecordType;

import lombok.Data;

@Data
public class FinancialRecordRequest {

    private Double amount;

    private RecordType type;

    private String category;

    private String notes;
    
    private LocalDate date;
}