package de.aperepublic.server.Repository;


import de.aperepublic.server.Entity.Position;
import de.aperepublic.server.Entity.PositionId;
import de.aperepublic.server.Entity.Stock;
import de.aperepublic.server.Entity.Users;
import de.aperepublic.server.repositories.PositionRepository;
import de.aperepublic.server.repositories.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PositionRepositoryTest {
    //alle positions wo iduser == x returnen?

//    @Autowired
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Autowired
//    private PositionRepository pRp;
//
//    @Test
//    @Transactional
//    public void benutzerausDBLaden(){
//        Position p = pRp.getReferenceById(new PositionId(1, "zwoelfISIN12"));
//        System.out.println(p.toString());
//        assertNotNull(p);
//    }
//
//    @Test
//    @Transactional
//    public void benutzerErstellen(){
//        Position p = new Position();
//        p.setIdUser(1);
//        p.setIsin("inis");
//        p.setAmount(new BigDecimal("10.3"));
//        p.setAvgBuyPrice(new BigDecimal("1934358.44"));
//        pRp.saveAndFlush(p);
//        pRp.flush();
//        System.out.println(p.toString());
//        assertNotNull(pRp.getReferenceById(new PositionId(1,"inis")));
//    }
}
