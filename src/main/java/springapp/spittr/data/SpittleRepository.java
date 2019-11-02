package springapp.spittr.data;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springapp.spittr.domain.Spitter;
import springapp.spittr.domain.Spittle;
import springapp.spittr.web.DuplicateSpittleException;
import sun.security.provider.ConfigFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {
    /*List<Spittle> findRecent(int count);

    Spittle findOne(long id);
    Spittle postSpittle(Spittle spittle) throws DuplicateSpittleException;*/


    @Query(value = "select * from Spittle as s order by s.time desc limit :counter", nativeQuery = true, name = "query")
    List<Spittle> findOrderedSpittles(@Param("counter") int count);

    @Modifying
    @Transactional
    @Query(value = "update Spittle set message = :message where id = :id")
    void updateSpittle(@Param("message") String message, @Param("id") Long id);
}
