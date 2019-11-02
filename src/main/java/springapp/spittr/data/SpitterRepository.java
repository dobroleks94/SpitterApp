package springapp.spittr.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springapp.spittr.domain.Spitter;
import sun.security.provider.ConfigFile;

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

     @Query(value = "insert into users (username, password) values (:username, :password)", nativeQuery = true)
     void saveUser(@Param("username") String username, @Param("password") String password);
}
