package springapp.spittr.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface SpitterSwapper {

    @Transactional
    @Modifying
    void addUser(String username, String password);
}
