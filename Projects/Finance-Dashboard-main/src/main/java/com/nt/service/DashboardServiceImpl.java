package com.nt.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nt.constants.RecordType;
import com.nt.dto.DashboardSummaryResponse;
import com.nt.dto.FinancialRecordResponse;
import com.nt.model.FinancialRecord;
import com.nt.repository.FinancialRecordRepository;
import com.nt.service_interface.DashboardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final FinancialRecordRepository recordRepository;

    @Override
    public DashboardSummaryResponse getDashboardSummary() {

        List<FinancialRecord> records = recordRepository.findAllByIsDeletedFalse();

        Double totalIncome = records.stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Double totalExpense = records.stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Double netBalance = totalIncome - totalExpense;

        Map<String, Double> categoryWise = records.stream()
                .collect(Collectors.groupingBy(
                        FinancialRecord::getCategory,
                        Collectors.summingDouble(FinancialRecord::getAmount)
                ));

        List<FinancialRecordResponse> recent = records.stream()
                .sorted(Comparator.comparing(FinancialRecord::getDate).reversed())
                .limit(5)
                .map(this::mapToResponse)
                .toList();

        return DashboardSummaryResponse.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .netBalance(netBalance)
                .categoryWiseTotals(categoryWise)
                .recentActivity(recent)
                .build();
    }

    private FinancialRecordResponse mapToResponse(FinancialRecord record) {
        return FinancialRecordResponse.builder()
                .amount(record.getAmount())
                .type(record.getType())
                .category(record.getCategory())
                .createdAt(record.getCreatedAt())
                .notes(record.getNotes())
                .build();
    }
}