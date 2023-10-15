package testcase.fellasads.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {
    @Value("${slack.webhook.url}")
    private String slackWebhookUrl;

    public void sendSlackMessage(String message) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(slackWebhookUrl, message, String.class);
    }
}
