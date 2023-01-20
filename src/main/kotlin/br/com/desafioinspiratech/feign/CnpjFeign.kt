package br.com.desafioinspiratech.feign

import br.com.desafioinspiratech.wrapper.CnpjWrapperRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader


@FeignClient(
    name = "api-busca-cnpj",
    value = "api-busca-cnpj",
    url = "https://receitaws.com.br"
)

interface CnpjFeign{

    @GetMapping("/v1/cnpj/{cnpj}")
    fun findAllByCnpj(@RequestHeader cnpj: String): CnpjWrapperRequest

}