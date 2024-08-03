package com.translate.Google.Translate.controller;

import com.translate.Google.Translate.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/languages")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @GetMapping("/translate")
    public Map<String, Object> translate(@RequestParam String text,
                                         @RequestParam String targetLanguage,
                                         @RequestParam String sourceLanguage) {
        return translationService.translate(text, targetLanguage, sourceLanguage);
    }

}
