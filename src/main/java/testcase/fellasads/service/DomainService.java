package testcase.fellasads.service;

import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testcase.fellasads.model.Domain;
import testcase.fellasads.repository.DomainRepository;

@Service
public class DomainService {
    private DomainRepository domainRepository;

    @Autowired
    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public boolean checkDomainStatus(String domainUrl) {

        try {
            URL url = new URL(domainUrl);
            HttpURLConnection httpGet = (HttpURLConnection) url.openConnection();
            int statusCode = httpGet.getResponseCode();

            if (statusCode == 502) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Domain save(Domain domain) {
        return domainRepository.save(domain);
    }
}
