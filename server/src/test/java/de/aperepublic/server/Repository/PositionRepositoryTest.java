package de.aperepublic.server.Repository;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
