//package springapp.spittr.data.jpa;
//
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import springapp.spittr.data.SpitterRepository;
//import springapp.spittr.domain.Spitter;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
//import javax.swing.text.html.parser.Entity;
//import java.util.List;
//
//@Repository
//@Transactional
//public class JpaSpitterRepository implements SpitterRepository {
//
//    /*@PersistenceUnit
//    private EntityManagerFactory emf;*/
//
//    @PersistenceContext
//    private EntityManager emf;
//
//
//
//    @Override
//    public Spitter save(Spitter spitter) {
////        ((Session)emf.getDelegate()).save(spitter);
//         emf.persist(spitter);
//         return spitter;
//    }
//
//    @Override
//    public Spitter findByUsername(String username) {
//        return  emf
//                .createQuery("SELECT s FROM Spitter s WHERE s.username=?1", Spitter.class)
//                .setParameter(1, username)
//                .getSingleResult();
//    }
//
//    @Override
//    public Spitter getSpitterById(Long id) {
//        return emf.find(Spitter.class, id);
//    }
//
//    @Override
//    public List<Spitter> findAll() {
//        return emf.createQuery("select s from Spitter s").getResultList();
//    }
//
//    @Override
//    public List<Spitter> searching(String spittername) {
//        return emf.createQuery("select s from Spitter s where s.username like ?1" +
//                "or s.firstName like ?2" +
//                "or s.lastName like ?3").setParameter(1, "%"+spittername+"%")
//                .setParameter(2, "%"+spittername+"%")
//                .setParameter(3, "%"+spittername+"%").getResultList();
//    }
//}
