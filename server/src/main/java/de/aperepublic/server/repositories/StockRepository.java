package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, String> {
}
