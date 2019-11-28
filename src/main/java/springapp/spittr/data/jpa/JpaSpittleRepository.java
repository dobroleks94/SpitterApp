//package springapp.spittr.data.jpa;
//
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import springapp.spittr.data.SpittleRepository;
//import springapp.spittr.domain.Spittle;
//import springapp.spittr.web.DuplicateSpittleException;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//@Transactional
//public class JpaSpittleRepository implements SpittleRepository {
//
//
//    @PersistenceContext
//    private EntityManager emf;
//
//
//
//    @Override
//    public List<Spittle> findRecent(int count) {
//        return emf.createQuery("select s from Spittle s")
//                .setMaxResults(count)
//                .getResultList();
//    }
//
//    @Override
//    public Spittle findOne(long id) {
//        return emf.find(Spittle.class, id);
//    }
//
//    @Override
//    public Spittle postSpittle(Spittle spittle) throws DuplicateSpittleException {
//        emf.persist(spittle);
//        return spittle;
//    }
//}
