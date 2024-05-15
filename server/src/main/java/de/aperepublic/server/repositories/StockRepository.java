package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

    @Query(
            nativeQuery = true,
            value = "insert into aperepublic.Stock\n" +
                    "Values(\"Test\", \"aus\", \"java\", \" ohne explizites Commit\");"
    )
    void saveStock();


    @Query(
            nativeQuery = true,
            value = "insert into aperepublic.Stock\n" +
                    "Values(\"Test\", \"aus\", \"java\", \"mit Commit\");\n" +
                    "commit;"
    )
    void saveStockWithCommit();

}
