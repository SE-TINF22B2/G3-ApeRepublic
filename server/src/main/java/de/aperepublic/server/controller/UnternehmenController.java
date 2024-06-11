package de.aperepublic.server.controller;

import de.aperepublic.server.models.CompanyProfile2;
import de.aperepublic.server.services.FinnhubCompanyProfile2Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
public class UnternehmenController {

    FinnhubCompanyProfile2Service companyProfile2Service;

    @GetMapping("/companyIsin")
    public CompanyProfile2 bedieneUnternehmenVonIsin(@RequestParam String isin) {
        return companyProfile2Service.getCompanyFromIsin(isin);
    }

    @GetMapping("/companySymbol")
    public CompanyProfile2 bedieneUnternehmenVonSymbol(@RequestParam String symbol) {
        return companyProfile2Service.getCompanyFromSymbol(symbol);
    }
}