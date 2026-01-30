package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class PartnershipService {
    @PersistenceContext
    private final EntityManager entityManager;

    public PartnershipService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership new_Partnership = new Partnership();
        new_Partnership.setProject(project);
        new_Partnership.setEnterprise(partnerEnterprise);
        new_Partnership.setCreationDate(new Date());

        entityManager.persist(new_Partnership);
        entityManager.flush();
        return new_Partnership;
    }

    public Partnership findPartnershipById(Object id) {
        return entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership partnership) {
        entityManager.remove(partnership);
        entityManager.flush();
    }
}
