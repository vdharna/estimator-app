package cloud.estimator.organization.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Organization {

	private @Id String id;
	private @NotNull String name;
	private String contactName;
	private String contactEmail;
	private String contactPhone;
	private @NotNull boolean active;
	private @CreatedDate LocalDateTime createdDate;
	private @LastModifiedDate LocalDateTime lastModifiedDate;

	@PrePersist
	private void ensureId() {
		this.id = UUID.randomUUID().toString();
	}

}
