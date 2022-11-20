package br.com.zoro.mockpayments.producer

import br.com.zoro.mockpayments.dto.PaymentEventDTO

interface IPaymentProducer {
    fun send(paymentEventDTO: PaymentEventDTO)
}