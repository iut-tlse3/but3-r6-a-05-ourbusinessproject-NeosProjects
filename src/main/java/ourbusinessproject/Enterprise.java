package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Enterprise {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 10)
    private String description;

    @NotNull
    @NotEmpty
    private String contactName;

    @NotNull
    @NotEmpty
    @Email
    private String contactEmail;

    public Enterprise() {
        this.name = null;
        this.description = null;
        this.contactName = null;
        this.contactEmail = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
