package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO Positions (idUser, symbol, amount, avgBuyPrice) VALUES (:idUser, :symbol, :amount, :avgBuyPrice)", nativeQuery = true)
//    void create(@Param("idUser") Integer idUser, @Param("symbol") String symbol, @Param("amount") BigDecimal amount, @Param("avgBuyPrice") BigDecimal avgBuyPrice);
//
//    @Transactional
//    default void create(Position position) {
//        create(position.getIdUser(), position.getSymbol(), position.getAmount(), position.getAvgBuyPrice());
//    }
//
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Positions p SET p.amount = :amount, p.avgBuyPrice = :avgBuyPrice WHERE p.idUser = :idUser AND p.symbol = :symbol")
    void updatePosition(@Param("idUser") Integer idUser, @Param("symbol") String symbol, @Param("amount") BigDecimal amount, @Param("avgBuyPrice") BigDecimal avgBuyPrice);

    @Transactional
    default void update(Position position) {
        updatePosition(position.getIdUser(), position.getSymbol(), position.getAmount(), position.getAvgBuyPrice());
    }

}

