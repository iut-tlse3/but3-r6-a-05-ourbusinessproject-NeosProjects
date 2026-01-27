package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private final EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Project newProject(String title, String description) {
        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setDescription(description);
        entityManager.persist(newProject);
        entityManager.flush();
        return newProject;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String mail) {
        Enterprise newEnterprise = new Enterprise();
        newEnterprise.setName(name);
        newEnterprise.setDescription(description);
        newEnterprise.setContactName(contactName);
        newEnterprise.setContactEmail(mail);
        entityManager.persist(newEnterprise);
        entityManager.flush();
        return newEnterprise;
    }

    public Project findProjectById(Long projectId) {
        return entityManager.find(Project.class, projectId);
    }

    public Enterprise findEnterpriseById(Long enterpriseId) {
        return entityManager.find(Enterprise.class, enterpriseId);
    }
}
