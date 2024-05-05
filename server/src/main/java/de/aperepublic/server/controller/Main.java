package de.aperepublic.server.controller;

import de.aperepublic.server.Entity.Stock;
import de.aperepublic.server.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Main {

    @Autowired
    public StockRepository sRp;

    @Transactional
    public void stockSpeichernTest() {
        // Stock erstellen
        System.out.println("trying to create STock");
        Stock s = new Stock();
        s.setISIN("zwoelfzeiche");
        s.setDescription("Dies könnte ihre Aktie sein");
        s.setName("Anisas sexyStock");
        s.setSymbol("AAnA");
        System.out.println("Stock created");


        // STock speichern
        Stock gespeicherterBenutzer = sRp.save(s);
        System.out.println("Stock Saved");
    }

}
