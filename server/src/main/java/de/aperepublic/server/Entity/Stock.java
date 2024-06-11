package de.aperepublic.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @Column(name = "ISIN", nullable = false, length = 12)
    public String ISIN;

    @Column(name = "symbol", nullable = true, length = 10)
    public String symbol;

    @Column(name = "name", nullable = true, length = 45)
    public String name;

    @Column(name = "description", nullable = true, length = 2048)
    public String description;


}
