package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, String> {

    @Modifying
    @Query(
            nativeQuery = true,
            value = "insert into aperepublic.Stock\n" +
                    "Values(\"Test2\", \"aus\", \"java\", \" ohne explizites Commit\");"
    )
    void saveStock();

    @Modifying
    @Query(
            nativeQuery = true,
            value = "INSERT INTO aperepublic.Stock (ISIN, symbol, name, description) " +
                    "VALUES ('Test', 'aus', 'java', 'mit Commit'); commit;"
    )
    void saveStockWithCommit();

}
