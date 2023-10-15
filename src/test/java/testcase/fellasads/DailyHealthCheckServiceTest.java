package testcase.fellasads;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.context.SpringBootTest;
import testcase.fellasads.service.DailyHealthCheckService;
import testcase.fellasads.service.SlackService;
import testcase.fellasads.util.MemoryHealthIndicator;

@SpringBootTest
public class DailyHealthCheckServiceTest {

    @InjectMocks
    private DailyHealthCheckService dailyHealthCheckService;

    @Mock
    private SlackService slackService;

    @Mock
    private MemoryHealthIndicator memoryHealthIndicator;

    @Test
    void testPerformDailyHealthCheck() {
        Health expectedHealth = Health.up()
                .withDetail("free_memory", 1000000 + " bytes")
                .withDetail("total_memory", 2000000 + " bytes")
                .withDetail("free_memory_percent", 50.0 + "%")
                .build();

        Mockito.when(memoryHealthIndicator.health()).thenReturn(expectedHealth);

        dailyHealthCheckService.performDailyHealthCheck();

        Mockito.verify(slackService, Mockito.times(1)).sendSlackMessage(expectedHealth.toString());
    }
}
