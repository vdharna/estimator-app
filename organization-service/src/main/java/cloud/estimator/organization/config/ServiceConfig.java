package cloud.estimator.organization.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

	private final Log log = LogFactory.getLog(getClass());
	private String exampleProperty;

	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("${example.property ?: not-set}")
	public void setExampleProperty(String exampleProperty) {
		log.info("Example Property is: " + exampleProperty);
	}

}
