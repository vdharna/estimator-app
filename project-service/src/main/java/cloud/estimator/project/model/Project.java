package cloud.estimator.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "project_id", nullable = false)
	private String projectId;

	@Column(name = "organization_id", nullable = false)
	private String organizationId;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "comment")
	private String comment;


}
