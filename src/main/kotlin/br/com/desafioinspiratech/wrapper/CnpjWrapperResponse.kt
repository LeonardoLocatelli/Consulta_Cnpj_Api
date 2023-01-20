package br.com.desafioinspiratech.wrapper

class CnpjWrapperRequest (
    val abertura :String? = null,
    val situacao :String? = null,
    val tipo :String? = null,
    val nome :String? = null,
    val fantasia :String? = null,
    val porte :String? = null,
    val natureza_juridica :String? = null,
    val logradouro :String? = null,
    val numero :String? = null,
    val municipio :String? = null,
    val bairro :String? = null,
    val uf :String? = null,
    val cep :String? = null,
    val data_situacao :String? = null,
    val motivo_situacao :String? = null,
    val cnpj :String? = null,
    val ultima_atualizacao :String? = null,
    val status :String? = null,
    val complemento :String? = null,
    val email :String? = null,
    val telefone :String? = null,
    val efr :String? = null,
    val situacao_especial :String? = null,
    val data_situacao_especial :String? = null,
    val atividade_principal: List<Atividade>? =null,
    val atividades_secundarias: List<Atividade>? =null,
    val capital_social :String? = null,
    val qsa :List<Any>? = null,
    val extra :Map<Any,Any>? = null,
    val billing:Billing? = null,
)

class Atividade(
    val code :String? = null,
    val text :String? = null
)

class Billing(
    val free :String? = null,
    val database :String? = null
)
