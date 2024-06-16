package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, String> {

}
