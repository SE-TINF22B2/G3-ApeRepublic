package de.aperepublic.server.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.math.BigDecimal;

@Entity
@Table(name = "Trades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    public static final String COLUMN_IDTRADE = "idTrade";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_SYMBOL = "symbol";
    public static final String COLUMN_IDUSER = "idUser";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = COLUMN_IDTRADE, insertable = true, updatable = true)
    public Integer idTrade;

    @Column(name = COLUMN_PRICE, nullable = false, precision = 10, scale = 2, insertable = true, updatable = true)
    public BigDecimal price;

    @Column(name = COLUMN_AMOUNT, nullable = false, precision = 10, scale = 2, insertable = true, updatable = true)
    public BigDecimal amount;

    @Column(name = COLUMN_SYMBOL, nullable = false, length = 32, insertable = true, updatable = true)
    public String symbol;

    @Column(name = COLUMN_IDUSER, nullable = false, insertable = true, updatable = true)
    public Integer idUser;

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("price", price);
        jsonObject.put("amount", amount);
        jsonObject.put("symbol", symbol);
        return jsonObject;
    }
}
