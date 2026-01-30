package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;
    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Transactional
    public void initProjects() {
        this.initEnterprises();
        this.project1E1 = enterpriseProjectService.newProject("p1E1", "description project 1 E1", getEnterprise1());
        this.project1E2 = enterpriseProjectService.newProject("p1E2", "description project 1 E2", getEnterprise2());
        this.project2E1 = enterpriseProjectService.newProject("p2E1", "description project 2 E1", getEnterprise1());
    }

    public void initEnterprises() {
        this.enterprise1 = enterpriseProjectService.newEnterprise("Enterprise 1", "Description Enterprise 1", "Contact 1", "nceczd@mail.com");
        this.enterprise2 = enterpriseProjectService.newEnterprise("Enterprise 2", "Description Enterprise 2", "Contact 2", "nuerifer@mail.com");
    }

    public Project getProject1E1() {
        return this.project1E1;
    }

    public Project getProject1E2() {
        return this.project1E2;
    }

    public Project getProject2E1() {
        return this.project2E1;
    }

    public Enterprise getEnterprise1() {
        return this.enterprise1;
    }

    public Enterprise getEnterprise2() {
        return this.enterprise2;
    }
}
