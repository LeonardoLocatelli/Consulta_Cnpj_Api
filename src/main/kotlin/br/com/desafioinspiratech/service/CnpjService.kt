package br.com.desafioinspiratech.service

import br.com.desafioinspiratech.feign.CnpjFeign
import br.com.desafioinspiratech.wrapper.CnpjWrapperRequest
import br.com.desafioinspiratech.wrapper.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.validation.BindingResult
import org.springframework.validation.DataBinder


@Service
class CnpjService(
        private val cnpjFeign: CnpjFeign,
) {
    fun buscaCnpj(cnpj: String): ApiResponse<CnpjWrapperRequest> {

        val retorno = cnpjFeign.findAllByCnpj(cnpj)
        return if(retorno.cnpj == null){
             ApiResponse(HttpStatus.BAD_REQUEST, message = "Cnpj nao encontrado")
        }else{
             ApiResponse(retorno)
        }

    }
}