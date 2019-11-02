//package springapp.spittr.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//import springapp.spittr.domain.Spitter;
//
//import java.util.List;
//
//@Repository
//public class SpitterRepositoryImpl implements SpitterRepository {
//
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    public SpitterRepositoryImpl(JdbcTemplate jdbc){
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public Spitter save(Spitter spitter) {
//
//        jdbc.update("insert into Spitters (username, password, first_name, last_name) values (?, ?, ?, ?);",
//                spitter.getUsername(),
//                spitter.getPassword(),
//                spitter.getFirstName(),
//                spitter.getLastName());
//
//        jdbc.update("insert into users (username, password, enabled) values (?, ?, ?);",
//                spitter.getUsername(),
//                new BCryptPasswordEncoder().encode(spitter.getPassword()),
//                true);
//        jdbc.update("insert into authorities (username, authority) values (?, 'ROLE_SPITTER')",
//                spitter.getUsername());
//        return spitter;
//    }
//
//    @Override
//    public Spitter findByUsername(String username) {
//        return jdbc.queryForObject(
//                "select * from Spitters where username = ?",
//                (rs, i) -> new Spitter(rs.getLong("id"),
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("first_name"),
//                    rs.getString("last_name")),
//                username);
//
//    }
//    @Override
//    public List<Spitter> searching(String spittername){
//        return jdbc.query(
//                "select * from Spitters where username like ? " +
//                        "                   or first_name like ? " +
//                        "                   or last_name like ?",
//                (rs, i) -> new Spitter(rs.getLong("id"),
//                        rs.getString("username"),
//                        rs.getString("password"),
//                        rs.getString("first_name"),
//                        rs.getString("last_name")),
//                "%"+spittername+"%",
//                "%"+spittername+"%",
//                "%"+spittername+"%");
//    }
//}
//
