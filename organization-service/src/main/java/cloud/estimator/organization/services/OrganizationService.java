package cloud.estimator.organization.services;

import org.springframework.stereotype.Service;

import cloud.estimator.organization.config.ServiceConfig;
import cloud.estimator.organization.model.Organization;
import cloud.estimator.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {

	private final OrganizationRepository organizationRepository;
	private final ServiceConfig serviceConfig;

	public OrganizationService(OrganizationRepository organizationRepository, ServiceConfig serviceConfig) {
		super();
		this.organizationRepository = organizationRepository;
		this.serviceConfig = serviceConfig;
	}

	public String getProperty() {
		return serviceConfig.getExampleProperty();
	}

}
