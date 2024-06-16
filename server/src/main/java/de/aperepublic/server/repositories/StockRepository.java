package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
//@Transactional
public interface StockRepository extends JpaRepository<Stock, String> {

//    @Modifying
//    @Query(
//            nativeQuery = true,
//            value = "insert into aperepublic.Stock\n" +
//                    "Values(\"Test2\", \"aus\", \"java\", \" ohne explizites Commit\");"
//    )
//    void saveStock();

}
