package com.nt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.constants.RecordType;
import com.nt.dto.FinancialRecordRequest;
import com.nt.dto.FinancialRecordResponse;
import com.nt.exception.ResourceNotFoundException;
import com.nt.model.FinancialRecord;
import com.nt.repository.FinancialRecordRepository;
import com.nt.service_interface.FinancialRecordService;

@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {

	@Autowired
	private FinancialRecordRepository recordRepository;

	@Override
	public FinancialRecordResponse createRecord(FinancialRecordRequest request) {
		FinancialRecord record = FinancialRecord.builder()
				.amount(request.getAmount())
				.type(request.getType())
				.category(request.getCategory().trim())
				.notes(request.getNotes())
				.date(request.getDate())
				.build();

		recordRepository.save(record);
		return mapToResponse(record);
	}

	@Override
	public List<FinancialRecordResponse> getAllRecords() {
		return recordRepository.findAllByIsDeletedFalse().stream().map(this::mapToResponse).toList();
	}

	@Override
	public FinancialRecordResponse getRecordById(UUID uuid) {
		FinancialRecord record = recordRepository.findByUuidAndIsDeletedFalse(uuid)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with uuid: " + uuid));

		return mapToResponse(record);
	}

	@Override
	public FinancialRecordResponse updateRecord(UUID uuid, FinancialRecordRequest request) {
		FinancialRecord record = recordRepository.findByUuidAndIsDeletedFalse(uuid)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with uuid: " + uuid));

		if (request.getAmount() != null) {
			record.setAmount(request.getAmount());
		}
		if (request.getType() != null) {
			record.setType(request.getType());
		}
		if (request.getCategory() != null && !request.getCategory().isBlank()) {
			record.setCategory(request.getCategory().trim());
		}
		if (request.getNotes() != null) {
			record.setNotes(request.getNotes());
		}

		recordRepository.save(record);
		return mapToResponse(record);
	}

	@Override
	public void deleteRecord(UUID uuid) {
		FinancialRecord record = recordRepository.findByUuidAndIsDeletedFalse(uuid)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with uuid: " + uuid));

		recordRepository.delete(record);
	}

	@Override
	public List<FinancialRecordResponse> filterRecords(RecordType type, String category, LocalDate startDate,
			LocalDate endDate) {

		if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
			throw new IllegalArgumentException("startDate must not be after endDate");
		}

		return recordRepository.filterRecords(type, category, startDate, endDate).stream().map(this::mapToResponse)
				.toList();
	}

	private FinancialRecordResponse mapToResponse(FinancialRecord record) {
		return FinancialRecordResponse.builder()
				.uuid(record.getUuid())
				.amount(record.getAmount())
				.type(record.getType())
				.category(record.getCategory())
				.createdAt(record.getCreatedAt())
				.notes(record.getNotes())
				.build();
	}
}