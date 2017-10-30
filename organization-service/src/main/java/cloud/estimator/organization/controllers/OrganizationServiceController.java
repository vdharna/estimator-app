package cloud.estimator.organization.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.estimator.organization.config.ServiceConfig;
import cloud.estimator.organization.services.OrganizationService;

import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String getProperty() {
		return serviceConfig.getExampleProperty();
	}
}
