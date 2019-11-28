//package springapp.spittr.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import springapp.spittr.domain.Spittle;
//import springapp.spittr.web.DuplicateSpittleException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SpittleRepositoryImpl implements SpittleRepository {
//
//    List<Spittle> spittles = new ArrayList<>();
//
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    public SpittleRepositoryImpl(JdbcTemplate jdbc){
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public List<Spittle> findSpittles(long max, int count) {
//        return jdbc.query(
//                "select id, message, created_at, latitude, longitude from Spittles " +
//                    "where id < ? " +
//                    "order by created_at desc limit ?",
//                (resultSet, i) -> new Spittle(resultSet.getLong("id"),
//                        resultSet.getString("message"),
//                        resultSet.getDate("created_at"),
//                        resultSet.getDouble("latitude"),
//                        resultSet.getDouble("longitude")),
//                max,
//                count);
//    }
//
//    @Override
//    public Spittle findOne(long id) {
//        Spittle spittle = jdbc.queryForObject(
//                "select * from Spittles where id = ?",
//                (resultSet, i) -> new Spittle(resultSet.getLong("id"),
//                        resultSet.getString("message"),
//                        resultSet.getDate("created_at"),
//                        resultSet.getDouble("latitude"),
//                        resultSet.getDouble("longitude")),
//                id);
//        return spittle;
//    }
//
//    public Spittle findByMessage(String message){
//        return jdbc.queryForObject("select message, created_at, latitude, longitude from Spittles where message = ?",
//                (rs, i) -> new Spittle(rs.getString("message"),
//                        rs.getDate("created_at"),
//                        rs.getDouble("latitude"),
//                        rs.getDouble("longitude")),
//                message);
//    }
//
//
//    @Override
//    public void postSpittle(Spittle spittle) throws DuplicateSpittleException {
//        jdbc.update("insert into Spittles (message, created_at, latitude, longitude) values (?, ?, ?, ?);",
//                spittle.getMessage(),
//                spittle.getTime(),
//                spittle.getLatitude(),
//                spittle.getLongitude());
//
//    }
//
//   /* create table Spittle (
//            id identity,
//            message varchar(140) not null,
//            created_at timestamp not null,
//            latitude double,
//            longitude double
//            );
//
//    create table Spitter (
//            id identity,
//            username varchar(20) unique not null,
//            password varchar(20) not null,
//            first_name varchar(30) not null,
//            last_name varchar(30) not null,
//            email varchar(30) not null
//            );             */
//}
