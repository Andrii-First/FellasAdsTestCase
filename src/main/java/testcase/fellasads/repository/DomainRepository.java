package testcase.fellasads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testcase.fellasads.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long> {
}
