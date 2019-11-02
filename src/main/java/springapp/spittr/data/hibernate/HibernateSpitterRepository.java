//package springapp.spittr.data;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import springapp.spittr.domain.Spitter;
//import sun.security.provider.ConfigFile;
//
//import javax.sql.DataSource;
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//
//@Repository
//@Transactional
//public class HibernateSpitterRepository implements SpitterRepository {
//
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public HibernateSpitterRepository(SessionFactory sessionFactory){
//        this.sessionFactory=sessionFactory;
//    }
//
//    private Session currentSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//    public long count(){
//        return findAll().size();
//    }
//
//    private List<Spitter> findAll() {
//        return currentSession().createCriteria(Spitter.class).list();
//    }
//
//
//    @Override
//    public Spitter save(Spitter spitter) {
//        Serializable id = currentSession().save(spitter);
//        return new Spitter((Long) id,
//                spitter.getUsername(),
//                spitter.getPassword(),
//                spitter.getFirstName(),
//                spitter.getLastName());
//    }
//
//    @Override
//    public Spitter findByUsername(String username) {
//        return (Spitter)currentSession()
//                .createCriteria(Spitter.class)
//                .add(Restrictions.eq("username", username))
//                .list()
//                .get(0);
//    }
//
//    @Override
//    public List<Spitter> searching(String spittername) {
//        return null;
//    }
//}
