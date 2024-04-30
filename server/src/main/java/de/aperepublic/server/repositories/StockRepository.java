package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
