package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Project newProject(String title, String description, Enterprise enterprise) {
        if (enterprise == null){
            throw new ConstraintViolationException("Enterprise cannot be null", null);
        }

        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setDescription(description);
        newProject.setEnterprise(enterprise);

        if(enterprise.getProjects() == null) {
            enterprise.setProjects(new java.util.ArrayList<>());
        }
        enterprise.getProjects().add(newProject);

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

    public List<Project> findAllProjects() {
        return entityManager.createQuery("SELECT p FROM Project p JOIN FETCH p.enterprise order by p.title", Project.class).getResultList();
    }
}
