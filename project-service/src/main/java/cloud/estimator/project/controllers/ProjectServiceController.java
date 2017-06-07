package cloud.estimator.project.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import cloud.estimator.project.config.ServiceConfig;
import cloud.estimator.project.model.Project;
import cloud.estimator.project.services.ProjectService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/projects")
public class ProjectServiceController {

	private final ProjectService projectService;
	private final ServiceConfig serviceConfig;

	public ProjectServiceController(ProjectService projectService, ServiceConfig serviceConfig) {
		super();
		this.projectService = projectService;
		this.serviceConfig = serviceConfig;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Project> getProjects(@PathVariable("organizationId") String organizationId) {
		return projectService.getProjectsByOrg(organizationId);
	}

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public Project getProject(@PathVariable("organizationId") String organizationId,
			@PathVariable("projectId") String projectId) {

		return projectService.getProject(organizationId, projectId);
	}

	@RequestMapping(value = "{projectId}", method = RequestMethod.PUT)
	public String updateProject(@PathVariable("projectId") String projectId) {
		return String.format("This is the put");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void saveProject(@RequestBody Project project) {
		projectService.saveProject(project);
	}

	@RequestMapping(value = "{projectId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteLicenses(@PathVariable("organizationId") String organizationId,
			@PathVariable("projectId") String projectId) {

		Project project = this.getProject(organizationId, projectId);
		if (project != null) {
			projectService.deleteProject(project);
		}

		return String.format("This is the Delete");
	}

	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String getProperty() {
		return serviceConfig.getExampleProperty();
	}
}
