package de.aperepublic.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class AktieHistorie {
    int anfrageStatus;
    Map<LocalDateTime, Double> history;
}