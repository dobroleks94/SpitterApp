package springapp.spittr.data;

import org.springframework.data.jpa.repository.Modifying;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class SpitterRepositoryImpl implements SpitterSwapper {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(String username, String password) {
        String addUser = "insert into users (username, password, enabled) values (?, ?, ?)";
        String addAuthority = "insert into authorities (username, authority) values (?, 'ROLE_SPITTER')";
        em.createNativeQuery(addUser).setParameter(1, username)
                                .setParameter(2, password)
                                .setParameter(3, true)
        .executeUpdate();
        em.createNativeQuery(addAuthority).setParameter(1, username).executeUpdate();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
