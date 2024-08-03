package com.translate.Google.Translate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "translation_records")
@Data
@NoArgsConstructor
public class TranslationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sourceLanguage;
    private String targetLanguage;
    private String originalText;
    private String translatedText;


    private LocalDateTime translatedAt;

    public TranslationRecord(String sourceLanguage, String targetLanguage,
                             String originalText, String translatedText) {

        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.originalText = originalText;
        this.translatedText = translatedText;
        this.translatedAt = LocalDateTime.now();
    }


}
