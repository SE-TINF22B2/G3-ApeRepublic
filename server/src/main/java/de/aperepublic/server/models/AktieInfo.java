package de.aperepublic.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AktieInfo {
    int anfrageStatus;
    String symbol;
    String name;
}