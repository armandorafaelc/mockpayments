package br.com.zoro.mockpayments.producer.impl

import br.com.zoro.mockpayments.dto.PaymentEventDTO
import br.com.zoro.mockpayments.producer.IPaymentProducer
import io.awspring.cloud.messaging.core.QueueMessagingTemplate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PaymentProducer(
    private val queueMessagingTemplate:QueueMessagingTemplate
):IPaymentProducer {
    val log = LoggerFactory.getLogger(this.javaClass)
    val queueName = "publisher-queue"

    override fun send(paymentEventDTO: PaymentEventDTO) {
        val process = kotlin.runCatching {
            queueMessagingTemplate.convertAndSend(queueName, paymentEventDTO)
        }
        process.onSuccess {
            log.info("Evento postado com sucesso: $paymentEventDTO")
        }.onFailure {
            log.error("Ocorreu o seguinte erro ao postar evento: ${it.message}")
        }
    }

}