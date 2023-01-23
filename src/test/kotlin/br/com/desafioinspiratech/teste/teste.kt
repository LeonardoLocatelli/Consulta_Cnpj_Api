package br.com.desafioinspiratech.teste

import br.com.desafioinspiratech.controller.CnpjController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class teste{

    @Autowired
    lateinit var cnpjController: CnpjController


    @Test
    fun buscaCnpjCorreto(){
        val cnpj = "02476335000106"
        val retorno = cnpjController.BuscaCnpj(cnpj)
        print("\n\n"+ retorno.message + "\n" + retorno.statusCode + ";\n\n")
        Assertions.assertEquals(200, retorno.statusCode)
    }

    @Test
    fun buscaCnpjIncorreto(){
        val cnpj = "024-76335.00010"
        val retorno = cnpjController.BuscaCnpj(cnpj)
        print("\n\n"+ retorno.message + "\n" + retorno.statusCode + ";\n\n")
        Assertions.assertEquals(400, retorno.statusCode)
    }
}