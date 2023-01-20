package br.com.desafioinspiratech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@EnableFeignClients
@SpringBootApplication
class ConsultaCnpjBaseReceitaFederalApplication

fun main(args: Array<String>) {
	runApplication<ConsultaCnpjBaseReceitaFederalApplication>(*args)
}
