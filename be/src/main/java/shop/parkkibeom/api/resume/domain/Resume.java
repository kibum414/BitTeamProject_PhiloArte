package shop.parkkibeom.api.resume.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resume {
    @Id
    @GeneratedValue
    @Column(name = "resume_id")
    private long resumeId;

}
