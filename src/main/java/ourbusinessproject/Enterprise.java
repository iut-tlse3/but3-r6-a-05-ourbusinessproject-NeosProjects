package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Collection;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Size(min = 10)
    @Column(nullable = false, length = 2000)
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private String contactName;

    @NotEmpty
    @Email
    @Column(nullable = false)
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    @JsonIgnore
    private Collection<Project> projects = null;

    public Enterprise() {
        this.name = null;
        this.description = null;
        this.contactName = null;
        this.contactEmail = null;
    }

    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // contactName
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    // contactEmail
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Project> getProjects() {
        return this.projects;
    }
}

