package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    private Partnership partnershipP1E1WithE2;;
    private Partnership partnershipP1E2WithE1;;
    private Partnership partnershipP2E1WithE2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Autowired
    private PartnershipService partnershipService;

    @Transactional
    public void initProjects() {
        /*
            Grâce à transactional on voit que si un projet provoque une erreur alors l'entièreté de la méthode est annulée avec un rollback.
         */

        this.initEnterprises();
        this.project1E1 = enterpriseProjectService.newProject("p1E1", "description project 1 E1", getEnterprise1());
        this.project1E2 = enterpriseProjectService.newProject("p1E2", "description project 1 E2", getEnterprise2());
        this.project2E1 = enterpriseProjectService.newProject("p2E1", "description project 2 E1", getEnterprise1());
    }

    @Transactional
    public void initEnterprises() {
        this.enterprise1 = enterpriseProjectService.newEnterprise("Enterprise 1", "Description Enterprise 1", "Contact 1", "nceczd@mail.com");
        this.enterprise2 = enterpriseProjectService.newEnterprise("Enterprise 2", "Description Enterprise 2", "Contact 2", "nuerifer@mail.com");
    }

    @Transactional
    public void initPartnerships() {
        this.partnershipP1E1WithE2 = partnershipService.newPartnership(getProject1E1(), getEnterprise2());
        this.partnershipP1E2WithE1 = partnershipService.newPartnership(getProject1E2(), getEnterprise1());
        this.partnershipP2E1WithE2 = partnershipService.newPartnership(getProject2E1(), getEnterprise2());
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

    public Partnership getPartnershipP1E1WithE2() {
        return this.partnershipP1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return this.partnershipP1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2() {
        return this.partnershipP2E1WithE2;
    }
}
