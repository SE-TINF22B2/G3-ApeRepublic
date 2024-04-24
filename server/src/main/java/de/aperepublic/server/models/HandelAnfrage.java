package de.aperepublic.server.models;

import lombok.Data;

@Data
public class HandelAnfrage {
    int anfrageStatus;
    boolean kaufStatus;
    String symbol;
    double menge;
    double preis;
}

