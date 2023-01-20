package br.com.desafioinspiratech.controller


import br.com.desafioinspiratech.service.CnpjService
import br.com.desafioinspiratech.utils.CnpjUtils
import br.com.desafioinspiratech.validator.CnpjValidate
import br.com.desafioinspiratech.wrapper.CnpjWrapperRequest
import br.com.desafioinspiratech.wrapper.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.validation.DataBinder
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin()
@RequestMapping("")
class CnpjController(
        private val cnpjService: CnpjService,
        private val cnpjUtils: CnpjUtils,
        private val cnpjValidate: CnpjValidate
){
    @GetMapping("v1/cnpj")
    fun BuscaCnpj(@RequestParam cnpj: String): ApiResponse<CnpjWrapperRequest> {
        val bindingResult: BindingResult = DataBinder(cnpj).bindingResult
        return try {
            cnpjValidate.validate(cnpj, bindingResult)
            if (bindingResult.hasErrors()) {
                ApiResponse(bindingResult = bindingResult)
            } else {
                cnpjService.buscaCnpj(cnpjUtils.removeMaskara(cnpj))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResponse(HttpStatus.BAD_REQUEST, message = "Erro ao procurar o Cnpj Digite novamente")
        }
    }
}