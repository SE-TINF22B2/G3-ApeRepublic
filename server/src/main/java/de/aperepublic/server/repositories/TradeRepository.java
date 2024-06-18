package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM Trades t WHERE t.idUser = :idUser AND t.symbol = :symbol")
    List<Trade> findAllByIdUserAndSymbol(@Param("idUser") Integer idUser, @Param("symbol") String symbol);

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO Trades (idUser, price, amount, symbol) VALUES (:idUser, :price, :amount, :symbol)", nativeQuery = true)
//    void create(@Param("idUser") Integer idUser, @Param("price") BigDecimal price, @Param("amount") BigDecimal amount, @Param("symbol") String symbol);
//
//    @Transactional
//    default void create(Trade trade) {
//        create(trade.getIdUser(), trade.getPrice(), trade.getAmount(), trade.getSymbol());
//    }
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Trades t SET t.price = :price, t.amount = :amount WHERE t.idTrade = :idTrade")
//    void updateTrade(@Param("idTrade") Integer idTrade, @Param("price") BigDecimal price, @Param("amount") BigDecimal amount);

}
