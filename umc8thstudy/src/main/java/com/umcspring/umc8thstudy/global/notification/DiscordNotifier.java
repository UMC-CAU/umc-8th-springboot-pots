package com.umcspring.umc8thstudy.global.notification;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Component
public class DiscordNotifier {

    public DiscordNotifier() {
        Dotenv dotenv = Dotenv.load();
        this.webhookUrl = dotenv.get("DISCORD_WEBHOOK_URL");
    }
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
