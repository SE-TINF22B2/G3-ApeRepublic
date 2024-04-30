package de.aperepublic.server.Repository;

import de.aperepublic.server.Entity.Stock;
import de.aperepublic.server.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class StockRepositoryTest {


    @Autowired
        private StockRepository sRp;

        @Test
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
            Stock gespeicherterBenutzer = sRp.save(s);
            System.out.println("Stock Saved");
            // Überprüfen, ob die ID des gespeicherten Benutzers nicht null ist
            assertNotNull(s.getISIN());
        }

    }


