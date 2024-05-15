package de.aperepublic.server.Repository;

import de.aperepublic.server.Entity.Stock;
import de.aperepublic.server.repositories.StockRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StockRepositoryTest {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private StockRepository sRp;

    @Test
    @Transactional
    public void benutzerSpeichernTest() {
        // Benutzer erstellen
        System.out.println("trying to create STock");
        Stock s = new Stock();
        s.setISIN("zwoelfzeiche");
        s.setDescription("Dies könnte ihre Aktie sein");
        s.setName("Anisas sexyStock");
        s.setSymbol("AAnA");
        System.out.println("Stock created");

        // Benutzer speichern
        Stock gespeicherterBenutzer = sRp.saveAndFlush(s);
        sRp.flush();

        System.out.println("Stock Saved");
        System.out.println("gespeicherter User: " + gespeicherterBenutzer.toString());
        System.out.println("Bneutzer aus DB: " + sRp.getReferenceById(s.getISIN()).toString());
        // Überprüfen, ob die ID des gespeicherten Benutzers nicht null ist
        //  assertNotNull(gespeicherterBenutzer.getISIN());
        assertEquals(s, sRp.getReferenceById(s.getISIN()));
    }

    @Test
    @Transactional
    public void stockAbfragen() {
        assertNotNull(sRp.getReferenceById("PURRRRRRR"));
    }

    @Test
    @Transactional
    public void stockErstellen() {
        sRp.saveStockWithCommit();
       // assertNotNull(sRp.getReferenceById("PURRRRRRR"));
    }
}


