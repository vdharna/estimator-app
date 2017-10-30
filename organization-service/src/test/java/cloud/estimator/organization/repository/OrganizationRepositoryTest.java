package cloud.estimator.organization.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import cloud.estimator.organization.model.Organization;
import cloud.estimator.organization.repository.OrganizationRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationRepositoryTest {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void findOrgShouldReturnOrg() throws Exception {
		Organization actual = this.organizationRepository.findOne("e254f8c-c442-4ebe-a82a-e2fc1d1ff78a");
		assertThat(actual).isNotNull();
		assertThat(actual.getContactName()).isEqualTo("Dharminder Dharna");
		// assertThat(actual.getFirstName()).isEqualTo("Jack");
		// assertThat(actual.getLastName()).isEqualTo("Frost");
		// assertThat(actual.getEmail()).isEqualTo("jfrost@example.com");
	}

}
