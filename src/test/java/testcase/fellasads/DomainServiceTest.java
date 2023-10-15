package testcase.fellasads;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import testcase.fellasads.repository.DomainRepository;
import testcase.fellasads.service.DomainService;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DomainServiceTest {

    @InjectMocks
    private DomainService domainService;

    @Mock
    private DomainRepository domainRepository;

    @Test
    void testCheckDomainStatusSuccess() {
        String domainUrl = "http://httpbin.org/status/502";
        boolean result = domainService.checkDomainStatus(domainUrl);
        assertTrue(result);
    }

    @Test
    void testCheckDomainStatusFailure() {
        String domainUrl = "https://example.com";
        boolean result = domainService.checkDomainStatus(domainUrl);
        assertFalse(result);
    }
}
