package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface StockRepository extends JpaRepository<Stock, String> {


}
