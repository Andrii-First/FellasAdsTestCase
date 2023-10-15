package testcase.fellasads.security;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Component
public class AuthorizationChecker {

    @Value("${expected_token}")
    private String expectedBearerToken;

    public boolean isAuthorized(String authorizationHeader) {
        if (authorizationHeader.isEmpty()) {
            return false;
        }

        String[] parts = authorizationHeader.split(" ");
        if (parts.length != 2 || !parts[0].equalsIgnoreCase("Bearer")) {
            return false;
        }

        String providedBearerToken = parts[1];
        return expectedBearerToken.equals(providedBearerToken);
    }
}
