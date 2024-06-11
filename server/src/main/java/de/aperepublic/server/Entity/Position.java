package de.aperepublic.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@IdClass(PositionId.class)
@Table(name = "positions")
public class Position {
    public static final String COLUMN_IDUSER= "idUser";
    public static final String COLUMN_ISIN = "ISIN";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_AVGBUYPRICE = "avgBuyPrice";

    public Position() {
    }

    @Id
    @Column(name = COLUMN_IDUSER, nullable = false , unique = true)
    public Integer idUser;

    @Id
    @Column(name = COLUMN_ISIN, nullable = false, length = 12)
    public String isin;

    @Column(name = COLUMN_AMOUNT, nullable = false, length = 32)
    public BigDecimal amount;

    @Column(name = COLUMN_AVGBUYPRICE, nullable = false, length = 32)
    public BigDecimal avgBuyPrice;
}
