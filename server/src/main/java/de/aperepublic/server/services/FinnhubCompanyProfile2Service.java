package de.aperepublic.server.services;

import de.aperepublic.server.models.CompanyProfile2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class FinnhubCompanyProfile2Service {
    private final String companyProfileBaseURL = "https://finnhub.io/api/v1/stock/profile2";
    private final String finnhubToken = "cl0cekhr01qs0rbeo410cl0cekhr01qs0rbeo41g";
    private final RestTemplate restTemplate = new RestTemplate();

    public CompanyProfile2 getCompanyFromIsin(String isin) {
        URI urlCompanyProfile = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("https://finnhub.io")
                .path("api/v1/stock/profile2")
                .queryParam("isin", isin)
                .queryParam("token", finnhubToken)
                .build().toUri();
        ResponseEntity<CompanyProfile2> responseEntity = restTemplate.getForEntity(urlCompanyProfile, CompanyProfile2.class);
        return responseEntity.getBody();
    }

}
