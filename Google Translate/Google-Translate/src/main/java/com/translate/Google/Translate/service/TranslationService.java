package com.translate.Google.Translate.service;

import com.translate.Google.Translate.client.GoogleTranslateClient;

import com.translate.Google.Translate.entity.TranslationRecord;
import com.translate.Google.Translate.repository.TranslationRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final GoogleTranslateClient googleTranslateClient;
    private final TranslationRecordRepository translationRecordRepository;


    @Value("${google.api.key}")
    private String apiKey;

    public Map<String, Object> translate(String text, String targetLanguage, String sourceLanguage) {
        // Preparing the request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("q", text);
        requestBody.put("target", targetLanguage);
        requestBody.put("source", sourceLanguage);

        // Call the Google Translate API
        Map<String, Object> response = googleTranslateClient.translate(apiKey, requestBody);

        // Save the translation record without user
        saveTranslationRecord(text, targetLanguage, sourceLanguage, response);

        return response;
    }

    private void saveTranslationRecord(String originalText, String targetLanguage, String sourceLanguage, Map<String, Object> response) {
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        List<Map<String, Object>> translations = (List<Map<String, Object>>) data.get("translations");
        String translatedText = (String) translations.get(0).get("translatedText");

        System.out.println("Translated Text: " + translatedText);  // Print extracted text to debug

        if (translatedText != null) {
            TranslationRecord record = new TranslationRecord(sourceLanguage, targetLanguage, originalText, translatedText);
            translationRecordRepository.save(record);
        } else {
            throw new RuntimeException("Translated text not found in the API response");
        }
    }


}
