package testcase.fellasads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import testcase.fellasads.security.AuthorizationChecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationCheckerTest {

    @Value("${expected_token}")
    private AuthorizationChecker authorizationChecker;

    @BeforeEach
    void setUp() {
        authorizationChecker = new AuthorizationChecker();
        authorizationChecker.setExpectedBearerToken("INPUT_EXPECTED_BEARER_TOKEN");
    }

    @Test
    void testAuthorizationSuccess() {
        String validAuthorizationHeader = "Bearer INPUT_EXPECTED_BEARER_TOKEN";
        assertTrue(authorizationChecker.isAuthorized(validAuthorizationHeader));
    }

    @Test
    void testAuthorizationFailureNoBearer() {
        String invalidAuthorizationHeader = "INPUT_EXPECTED_BEARER_TOKEN";
        assertFalse(authorizationChecker.isAuthorized(invalidAuthorizationHeader));
    }

    @Test
    void testAuthorizationFailureWrongToken() {
        String invalidAuthorizationHeader = "Bearer wrong_token";
        assertFalse(authorizationChecker.isAuthorized(invalidAuthorizationHeader));
    }
}
