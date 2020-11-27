package com.microservice.customer.provider;


import com.microservice.customer.connector.CardsConnector;
import com.microservice.customer.dto.CardDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector cardsConnector;

    @HystrixCommand(fallbackMethod = "fallbackGetCards")
    public List<CardDto> getCustomerCards(Long customerId){
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(
                        card.getNrb(),
                        card.getDebet()))
                .collect(Collectors.toList());
    }

}
