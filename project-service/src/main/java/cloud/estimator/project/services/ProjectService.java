package cloud.estimator.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.estimator.project.config.ServiceConfig;
import cloud.estimator.project.model.Project;
import cloud.estimator.project.repository.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final ServiceConfig serviceConfig;

	public ProjectService(ProjectRepository projectRepository, ServiceConfig serviceConfig) {
		super();
		this.projectRepository = projectRepository;
		this.serviceConfig = serviceConfig;
	}

	public Project getProject(String organizationId, String projectId) {
		return projectRepository.findByOrganizationIdAndProjectId(organizationId, projectId);
	}

	public Project getProject(String projectId) {
		return projectRepository.findOne(projectId);
	}

	public List<Project> getProjectsByName(String organizationId, String projectName) {
		return projectRepository.findByOrganizationIdAndProjectName(organizationId, projectName);
	}

	public List<Project> getProjectsByOrg(String organizationId) {
		return projectRepository.findByOrganizationId(organizationId);
	}

	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}

	public String getCustomProperty() {
		return serviceConfig.getExampleProperty();
	}

}
