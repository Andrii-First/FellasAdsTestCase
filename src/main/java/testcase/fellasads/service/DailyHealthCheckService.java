package testcase.fellasads.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import testcase.fellasads.util.MemoryHealthIndicator;

@RequiredArgsConstructor
@Service
public class DailyHealthCheckService {
    private final SlackService slackService;
    private final MemoryHealthIndicator memoryHealthIndicator;

    @Scheduled(cron = "0 0 0 * * *")
    public void performDailyHealthCheck() {
        slackService.sendSlackMessage(String.valueOf(memoryHealthIndicator.health()));
    }
}
