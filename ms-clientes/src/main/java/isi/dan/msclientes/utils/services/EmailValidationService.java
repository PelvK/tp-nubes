package isi.dan.msclientes.utils.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import isi.dan.msclientes.utils.model.EmailValidationResponse;

@Service
public class EmailValidationService {

    @Value("${mailgun.api.key}")
    private String apiKey;

    @Value("${mailgun.api.url}")
    private String apiUrl;

    public boolean validateEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/address/validate?address=%s&api_key=%s", apiUrl, email, apiKey);
        EmailValidationResponse response = restTemplate.getForObject(url, EmailValidationResponse.class);
        return response != null && response.isValid();
    }
}



