package br.com.desafioinspiratech.wrapper.response

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import java.io.Serializable
import java.util.*
import java.util.stream.Collectors

class ApiResponse<T>: Serializable {

    var status: HttpStatus = HttpStatus.OK
    var message: String = ""
    var messages: List<String> = arrayListOf()
    var data: T? = null

    val statusCode: Int get() = status.value()

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    constructor(@JsonProperty("status") status: HttpStatus = HttpStatus.OK,
                @JsonProperty("message") message: String = "Operação realizada com sucesso",
                @JsonProperty("messages") messages: ArrayList<String> = arrayListOf(),
                @JsonProperty("data") data: T? = null) : super() {
        this.status = status
        this.message = message
        this.messages = messages
        this.data = data
    }

    constructor(data: T?) : super() {
        this.status = HttpStatus.OK
        this.messages = arrayListOf()
        this.message = "Operação realizada com sucesso."
        this.data = data
    }

    constructor(data: T?, message: String) : super() {
        this.status = HttpStatus.OK
        this.messages = arrayListOf()
        this.message = message
        this.data = data
    }

    constructor(status: HttpStatus, data: T?) : super() {
        this.status = status
        this.messages = arrayListOf()
        this.message = "Operação realizada com sucesso."
        this.data = data
    }

    constructor(messages: ArrayList<String>) : super() {
        this.status = HttpStatus.BAD_REQUEST
        this.messages = messages
        this.message = ""
        this.data = null
    }

    constructor(message: String, messages: ArrayList<String>) : super() {
        this.status = HttpStatus.BAD_REQUEST
        this.messages = messages
        this.message = message
        this.data = null
    }

    constructor(bindingResult: BindingResult) : super() {
        this.status = HttpStatus.CONFLICT
        this.data = null
        val errors: List<String> = bindingResult
            .allErrors.stream().map { e -> e.defaultMessage }.collect(Collectors.toList<String>())
        this.messages = this.messages.plus(errors)
        this.message = errors[0]
    }


    constructor(status: HttpStatus, data: T?, messages: ArrayList<String>) : super() {
        this.status = status
        this.messages = messages
        this.data = data
        this.message = "Operação realizada com sucesso."
    }

    constructor(status: HttpStatus) : super() {
        this.status = status
        this.messages = arrayListOf()
        this.data = null
        this.message = ""
    }

    constructor(status: HttpStatus, message: String) : super() {
        this.status = status
        this.messages = arrayListOf()
        this.data = null
        this.message = message
    }

    fun toJson() : String{
        return ObjectMapper().writeValueAsString(this)
    }
}