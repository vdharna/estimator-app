package cloud.estimator.project.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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

	@PrePersist
	private void ensureId() {
		this.setProjectId(UUID.randomUUID().toString());
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
