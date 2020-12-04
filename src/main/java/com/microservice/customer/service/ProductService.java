package com.microservice.customer.service;

import com.microservice.customer.dto.AccountDto;
//import com.microservice.customer.dto.CardDto;
import com.microservice.customer.provider.AccountsProvider;
//import com.microservice.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final AccountsProvider accountProvider;
//    private final CardsProvider cardProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountProvider.getCustomerAccounts(customerId);
    }
//    public List<CardDto> findCustomerCards(Long customerId) {
//        return cardProvider.getCustomerCards(customerId);
//    }
}

