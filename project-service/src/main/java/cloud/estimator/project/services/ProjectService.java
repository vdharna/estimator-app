package cloud.estimator.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.estimator.project.clients.OrganizationRestTemplateClient;
import cloud.estimator.project.config.ServiceConfig;
import cloud.estimator.project.model.Organization;
import cloud.estimator.project.model.Project;
import cloud.estimator.project.repository.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final ServiceConfig serviceConfig;
	private final OrganizationRestTemplateClient organizationRestClient;

	public ProjectService(ProjectRepository projectRepository, ServiceConfig serviceConfig,
			OrganizationRestTemplateClient organizationRestClient) {
		super();
		this.projectRepository = projectRepository;
		this.serviceConfig = serviceConfig;
		this.organizationRestClient = organizationRestClient;
	}

	private Organization retrieveOrgInfo(String organizationId) {

		Organization organization = organizationRestClient.getOrganization(organizationId);
		return organization;
	}

	public Project getProject(String organizationId, String projectId) {
		Project project = projectRepository.findByOrganizationIdAndProjectId(organizationId, projectId);
		Organization organization = retrieveOrgInfo(organizationId);

		project.setOrganizationName(organization.getName());
		project.setContactEmail(organization.getContactEmail());
		project.setContactName(organization.getContactName());
		project.setContactPhone(organization.getContactPhone());

		return project;
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

	public List<Project> getProjectsByNameContains(String organizationId, String projectName) {
		return projectRepository.findByOrganizationIdAndProjectNameContains(organizationId, projectName);
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
