package de.aperepublic.server.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.math.BigDecimal;

@Data
@Entity
@IdClass(PositionId.class)
@Table(name = "Positions")
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    public static final String COLUMN_IDUSER= "idUser";
    public static final String COLUMN_SYMBOL = "symbol";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_AVGBUYPRICE = "avgBuyPrice";

    @Id
    @Column(name = COLUMN_IDUSER, insertable = true, updatable = true)
    public Integer idUser;

    @Id
    @Column(name = COLUMN_SYMBOL, nullable = false, length = 10, insertable = true, updatable = true)
    public String symbol;

    @Column(name = COLUMN_AMOUNT, nullable = false, length = 32, insertable = true, updatable = true)
    public BigDecimal amount;

    @Column(name = COLUMN_AVGBUYPRICE, nullable = false, length = 32, insertable = true, updatable = true)
    public BigDecimal avgBuyPrice;

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("symbol", symbol);
        jsonObject.put("amount", amount);
        jsonObject.put("avgBuyPrice", avgBuyPrice);
        return jsonObject;
    }

}
