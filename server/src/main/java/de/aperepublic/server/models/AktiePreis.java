package de.aperepublic.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AktiePreis {
    int anfrageStatus;
    String symbol;
    double preis;
}