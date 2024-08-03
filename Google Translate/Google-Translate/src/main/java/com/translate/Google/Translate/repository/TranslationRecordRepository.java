package com.translate.Google.Translate.repository;


import com.translate.Google.Translate.entity.TranslationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRecordRepository extends JpaRepository<TranslationRecord, Integer> {


}
