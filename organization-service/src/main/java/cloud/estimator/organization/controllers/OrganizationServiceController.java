package cloud.estimator.organization.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import cloud.estimator.organization.config.ServiceConfig;
import cloud.estimator.organization.model.Organization;
import cloud.estimator.organization.services.OrganizationService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {

	private final OrganizationService organizationService;
	private final ServiceConfig serviceConfig;

	public OrganizationServiceController(OrganizationService organizationService, ServiceConfig serviceConfig) {
		super();
		this.organizationService = organizationService;
		this.serviceConfig = serviceConfig;
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		return organizationService.getOrg(organizationId);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
		organizationService.saveOrg(org);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization org) {
		organizationService.saveOrg(org);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("orgId") String orgId, @RequestBody Organization org) {
		organizationService.deleteOrg(org);
	}

	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String getProperty() {
		return serviceConfig.getExampleProperty();
	}
}
