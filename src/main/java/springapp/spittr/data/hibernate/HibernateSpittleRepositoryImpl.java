//package springapp.spittr.data;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import springapp.spittr.domain.Spittle;
//import springapp.spittr.web.DuplicateSpittleException;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Repository
//@Transactional
//public class HibernateSpittleRepositoryImpl implements SpittleRepository {
//
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public HibernateSpittleRepositoryImpl(SessionFactory sessionFactory){
//        this.sessionFactory=sessionFactory;
//    }
//
//
//    public Session currentSession(){return sessionFactory.getCurrentSession();}
//
//    @Override
//    public List<Spittle> findRecent(int count) {
//        return (List<Spittle>) currentSession().createCriteria(Spittle.class).setMaxResults(count).list();
//    }
//
//    @Override
//    public Spittle findOne(long id) {
//        return currentSession().get(Spittle.class, id);
//    }
//
//    @Override
//    public Spittle postSpittle(Spittle spittle) throws DuplicateSpittleException {
//        Serializable id = currentSession().save(spittle);
//        return new Spittle((Long) id, spittle.getMessage(), spittle.getTime(), spittle.getLatitude(), spittle.getLongitude());
//    }
//}
