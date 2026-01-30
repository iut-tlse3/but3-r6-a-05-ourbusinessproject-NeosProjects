package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    private final InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
            initializationService.initPartnerships();
        } catch (RuntimeException e) {
            // Catching RuntimeException to prevent application crash during initialization
        }
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
