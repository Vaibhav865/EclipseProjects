package com.nt.dto;
import java.time.LocalDateTime;
import java.util.UUID;

import com.nt.constants.RecordType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinancialRecordResponse {
    private UUID uuid;
    private Double amount;
    private RecordType type;
    private String category;
    private String notes;
    private LocalDateTime createdAt;
}