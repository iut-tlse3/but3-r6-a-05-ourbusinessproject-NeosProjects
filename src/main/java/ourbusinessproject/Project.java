package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Project {
    @NotBlank(message = "title must not be blank")
    @NotNull(message = "title must not be null")
    private String title;
    private String description;

    public Project() {
        this.title = null;
        this.description = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
