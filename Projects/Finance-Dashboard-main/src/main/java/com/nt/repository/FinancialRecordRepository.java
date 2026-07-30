package com.nt.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.constants.RecordType;
import com.nt.model.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    Optional<FinancialRecord> findByUuidAndIsDeletedFalse(UUID uuid);

    List<FinancialRecord> findAllByIsDeletedFalse();

    @Query("""
            SELECT r FROM FinancialRecord r
            WHERE r.isDeleted = false
            AND (:type     IS NULL OR r.type     = :type)
            AND (:category IS NULL OR LOWER(r.category) = LOWER(:category))
            AND (:start    IS NULL OR r.date    >= :start)
            AND (:end      IS NULL OR r.date    <= :end)
            ORDER BY r.date DESC
            """)
    List<FinancialRecord> filterRecords(
            @Param("type")     RecordType type,
            @Param("category") String category,
            @Param("start")    LocalDate start,
            @Param("end")      LocalDate end
    );
}
