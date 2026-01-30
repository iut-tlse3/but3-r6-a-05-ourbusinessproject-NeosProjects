package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @RequestMapping(value = "/projects", method= RequestMethod.GET)
    @JsonIgnore
    public List<Project> findAllProjectsWithEnterprises() {
        return this.enterpriseProjectService.findAllProjects();
    }
}
