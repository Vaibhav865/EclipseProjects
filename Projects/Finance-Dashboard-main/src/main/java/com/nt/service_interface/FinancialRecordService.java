package com.nt.service_interface;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.nt.constants.RecordType;
import com.nt.dto.FinancialRecordRequest;
import com.nt.dto.FinancialRecordResponse;

public interface FinancialRecordService {
	FinancialRecordResponse createRecord(FinancialRecordRequest request);

    List<FinancialRecordResponse> getAllRecords();

    FinancialRecordResponse getRecordById(UUID uuid);

    FinancialRecordResponse updateRecord(UUID uuid, FinancialRecordRequest request); // was Long

    void deleteRecord(UUID uuid);

    List<FinancialRecordResponse> filterRecords(
            RecordType type,
            String category,
            LocalDate startDate,
            LocalDate endDate
    );
}