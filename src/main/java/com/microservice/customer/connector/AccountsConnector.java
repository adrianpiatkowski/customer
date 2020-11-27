package com.microservice.customer.connector;

import com.microservice.customer.connector.response.GetAccountsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@RibbonClient(name = "accounts")
@FeignClient(name = "accounts" , fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    GetAccountsResponse getAccounts(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class AccountsConnectorFallback implements AccountsConnector {
    @Override
    public GetAccountsResponse getAccounts(Long customerId) {
        log.warn("Can not get accounts for customerId: {}", customerId);
        return new GetAccountsResponse(Collections.emptyList());
    }
}