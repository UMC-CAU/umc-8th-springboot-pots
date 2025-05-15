package com.umcspring.umc8thstudy.global.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Component
public class DiscordNotifier {

    @Value("${discord.webhook.url}")
    private String webhookUrl;

    public void sendMessage(String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> body = Map.of("content", message);
            restTemplate.postForEntity(webhookUrl, body, String.class);
        } catch (Exception e) {
            log.error("❌ Discord 전송 실패: {}", e.getMessage());
        }
    }
}
