package de.aperepublic.server.services;

import de.aperepublic.server.Entity.Stock;
import de.aperepublic.server.repositories.StockRepository;

//@Service
// TODO: StockDataRepository-Bean wird nicht verknüpft
public class StockManagementService {

    //@Autowired
    private StockRepository stockRepository;

    public void saveStock(Stock stock){
        stockRepository.save(stock);
    }

}
