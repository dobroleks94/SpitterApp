package springapp.spittr.data;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import springapp.spittr.domain.Spitter;


import javax.persistence.EntityManager;

public interface SpitterSwapper {

    @Transactional
    @Modifying
    void addUser(String username, String password);

    EntityManager getEntityManager();
}
