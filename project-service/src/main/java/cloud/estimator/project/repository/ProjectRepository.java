package cloud.estimator.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cloud.estimator.project.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

	public List<Project> findByOrganizationId(String organizationId);

	public List<Project> findByOrganizationIdAndProjectId(String organizationId, String projectId); 

}
