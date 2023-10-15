package testcase.fellasads;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import testcase.fellasads.controller.DomainController;
import testcase.fellasads.model.Domain;
import testcase.fellasads.security.AuthorizationChecker;
import testcase.fellasads.service.DomainService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DomainControllerTest {

    @InjectMocks
    private DomainController domainController;

    @Mock
    private AuthorizationChecker authorizationChecker;

    @Mock
    private DomainService domainService;


    @Test
    void testAddDomainSuccess() {
        String validAuthorizationHeader = "Bearer mock_token";
        Mockito.when(authorizationChecker.isAuthorized(validAuthorizationHeader)).thenReturn(true);

        Domain domain = new Domain();
        domain.setName("example.com");
        Mockito.when(domainService.save(domain)).thenReturn(domain);

        String domainUrl = "https://" + domain.getName();
        Mockito.when(domainService.checkDomainStatus(domainUrl)).thenReturn(false);

        ResponseEntity<Domain> response = domainController.addDomain(validAuthorizationHeader, domain);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testAddDomainUnauthorized() {
        String invalidAuthorizationHeader = "Bearer wrong_token";
        Mockito.when(authorizationChecker.isAuthorized(invalidAuthorizationHeader)).thenReturn(false);

        Domain domain = new Domain();
        domain.setName("example.com");

        ResponseEntity<Domain> response = domainController.addDomain(invalidAuthorizationHeader, domain);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
