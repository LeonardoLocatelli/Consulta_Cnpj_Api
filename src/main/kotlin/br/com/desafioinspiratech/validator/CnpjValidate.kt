package br.com.desafioinspiratech.validator

import br.com.desafioinspiratech.utils.CnpjUtils
import org.springframework.stereotype.Service
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Service
class CnpjValidate (
        private val cnpjUtil: CnpjUtils
) : Validator {

    override fun supports(receivedClass: Class<*>): Boolean {
        return br.com.desafioinspiratech.wrapper.CnpjWrapperRequest::class.java.isAssignableFrom(receivedClass)
    }

    override fun validate(target: Any, errors: Errors) {
        val bindingResult = BeanPropertyBindingResult(target, errors.objectName)
        val cnpj = target.toString()
        try{
            if(!(cnpj.length == 14 || cnpj.length==18)){
                val message = "Cnpj nao e valido"
                errors.rejectValue("",message,message)
            }
            if(cnpjUtil.removeMaskara(cnpj).length !=14){
                val message = "Cnpj nao conta com numeros suficientes para ser valido"
                errors.rejectValue("",message,message)
            }
            if (cnpj.contains("[^0-9/.-]".toRegex())) {
                val message = "Cnpj contem caracteres que nao existem num cnpj"
                errors.rejectValue("", message, message)
            }
        }catch (e: Exception){
            errors.addAllErrors(bindingResult)
        }
    }
}