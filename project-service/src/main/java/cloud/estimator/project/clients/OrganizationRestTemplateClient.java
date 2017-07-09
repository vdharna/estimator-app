package cloud.estimator.project.clients;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cloud.estimator.project.model.Organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OrganizationRestTemplateClient {

	private final RestTemplate restTemplate;

	public OrganizationRestTemplateClient(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	private static final Logger logger = LoggerFactory.getLogger(OrganizationRestTemplateClient.class);

	public Organization getOrganization(String organizationId) {
		logger.debug(">>> In Licensing Service.getOrganization");
		ResponseEntity<Organization> restExchange = restTemplate.exchange(
				"http://zuul-server/api/organization/v1/organizations/{organizationId}", HttpMethod.GET, null,
				Organization.class, organizationId);
		return restExchange.getBody();
	}
}