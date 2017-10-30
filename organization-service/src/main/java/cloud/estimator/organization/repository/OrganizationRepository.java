package cloud.estimator.organization.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import cloud.estimator.organization.model.Organization;

@Repository
@RepositoryRestResource
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, String> {

	@RestResource(path = "name", rel = "name")
	public Page<Organization> findByName(@Param("name") String arg, Pageable p);

	@RestResource(path = "contact-name", rel = "contact-name")
	public Page<Organization> findByContactName(@Param("name") String arg, Pageable p);

	@RestResource(path = "contact-email", rel = "contact-email")
	public Page<Organization> findByContactEmail(@Param("email") String arg, Pageable p);

	@RestResource(path = "contact-phone", rel = "contact-phone")
	public Page<Organization> findByContactPhone(@Param("phone") String arg, Pageable p);

	@RestResource(path = "name-starts-with", rel = "name-starts-with")
	public Page<Organization> findByNameStartsWith(@Param("name") String arg, Pageable p);

	@Override
	default void delete(Iterable<? extends Organization> entities) {
		if (entities != null) {
			entities.forEach(entity -> {
				entity.setActive(false);
			});
		}
	}

	@Override
	default void delete(Organization entity) {
		if (entity != null) {
			entity.setActive(false);
		}
	}

	@Override
	default void delete(String id) {
		Organization entity = findOne(id);
		delete(entity);
	}

	@Override
	default void deleteAll() {
		delete(findAll());

	}

}
