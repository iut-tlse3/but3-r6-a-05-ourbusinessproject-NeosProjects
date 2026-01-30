package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "partnerships")
public class Partnership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date creationDate;

    @ManyToOne
    @NotNull
    private Enterprise enterprise;

    @ManyToOne
    @NotNull
    private Project project;

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Project getProject() {
        return project;
    }

    public Long getId() {
        return this.id;
    }
}
