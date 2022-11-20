package br.com.zoro.mockpayments.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentEventDTO (
    @JsonProperty("namePayer")
    val namePayer: String,
    @JsonProperty("nameReceiver")
    val nameReceiver: String,
    @JsonProperty("e2e")
    val e2e : String,
    @JsonProperty("amount")
    val amount: String? = null,
    @JsonProperty("situation")
    val situation: Boolean? =null
)