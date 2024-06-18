package de.aperepublic.server.Repository;


import de.aperepublic.server.Entity.User;
import de.aperepublic.server.repositories.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private UsersRepository uRp;

    @Test
    @Transactional
    public void benutzerausDBLaden(){
        User u = uRp.getReferenceById(1);
        System.out.println(u.toString());
        assertNotNull(u);
    }

    @Test
    @Transactional
    public void benutzerErstellen(){
        User u = new User();
        u.setFirstname("intelli");
        u.setLastname("J");
        u.setPassword("pw");
        u.setUsername("usernam");
        u.setEmail("email@email.com");
        u.setBirthday(java.sql.Date.valueOf("2004-10-02"));
        User i = uRp.saveAndFlush(u);
        uRp.flush();
        System.out.println(i.toString());
        assertNotNull(uRp.getReferenceById(i.getUserID()));
    }


}
