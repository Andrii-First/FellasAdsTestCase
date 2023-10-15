package testcase.fellasads.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testcase.fellasads.model.Domain;
import testcase.fellasads.security.AuthorizationChecker;
import testcase.fellasads.service.DomainService;
import testcase.fellasads.service.SlackService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/domains")
public class DomainController {
    private final AuthorizationChecker authorizationChecker;
    private final SlackService slackService;
    private final DomainService domainService;

    @PostMapping
    public ResponseEntity<Domain> addDomain(
            @RequestHeader("Authorization") String authorizationHeader,
                                            @RequestBody Domain domain) {
        if (!authorizationChecker.isAuthorized(authorizationHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        Domain savedDomain = domainService.save(domain);
        String domainUrl = "https://" + savedDomain.getName();

        if (domainService.checkDomainStatus(domainUrl)) {
            slackService.sendSlackMessage("Domain " + domainUrl + " has the correct status (502).");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDomain);
    }
}

