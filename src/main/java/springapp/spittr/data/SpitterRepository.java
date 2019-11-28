package springapp.spittr.data;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springapp.spittr.domain.Spitter;

import java.util.List;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSwapper {
    /*Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
    Spitter getSpitterById(Long id);
    List<Spitter> findAll();
    List<Spitter> searching(String spittername);*/

    Spitter findByUsername(String name);
    List<Spitter> findAllByFirstNameContainingOrLastNameContainingOrUsernameContaining(String fn, String ln, String un);
}
