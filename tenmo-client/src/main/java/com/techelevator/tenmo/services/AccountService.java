package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AccountService {
    private String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public AccountService(String url) {
        this.API_BASE_URL = url;

    }

    public Account getBalance(int userId) {
        Account account = null;
//        try {
        ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL + "user/" + userId +
                "/balance", HttpMethod.GET, makeAuthEntity(), Account.class);

                account = response.getBody();
//        } catch (RestClientResponseException e) {
//            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
//        } catch (ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
        return account;
    }

    private HttpEntity<Account> makeAccountEntity(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);

        return new HttpEntity<>(account, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}


