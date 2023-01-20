package br.com.desafioinspiratech.utils

import org.springframework.stereotype.Service

@Service
class CnpjUtils {

    fun removeMaskara(cnpj: String) :String{
        return cnpj.replace(regex = Regex("[/.-]"),"")
    }
}