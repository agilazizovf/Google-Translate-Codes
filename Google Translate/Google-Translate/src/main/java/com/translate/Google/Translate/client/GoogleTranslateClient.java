package com.translate.Google.Translate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "google-translate", url = "https://translation.googleapis.com")
public interface GoogleTranslateClient {

    @PostMapping("/language/translate/v2")
    Map<String, Object> translate(@RequestParam("key") String apiKey, @RequestBody Map<String, Object> body);
}
