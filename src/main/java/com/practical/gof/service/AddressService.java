package com.practical.gof.service;

import com.practical.gof.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface AddressService {

    @GetMapping("/{cep}/json/")
    Address checkCep(@PathVariable("cep") String cep);
}