package br.com.zoro.mockpayments.service.impl

import br.com.zoro.mockpayments.dto.PaymentEventDTO
import br.com.zoro.mockpayments.producer.impl.PaymentProducer
import br.com.zoro.mockpayments.service.IGetFakeUserFeignClient
import br.com.zoro.mockpayments.service.IMockWorker
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import kotlin.random.Random

@Service
@EnableScheduling
class MockWorker(
    private val fakeUser: IGetFakeUserFeignClient,
    private val paymentProducer: PaymentProducer
): IMockWorker {
    val log = LoggerFactory.getLogger(this.javaClass)

    @Scheduled(initialDelay = 2000, fixedDelay = 1000)
    override fun fixedRateScheduledTask() {
        paymentProducer.send(getPayment())
    }

    private fun getPayment():PaymentEventDTO {
        val fakeClient = fakeUser.getFakeClient()
        val re = Regex("[^0-9]")

        return PaymentEventDTO(
            namePayer = fakeClient.first_name!!,
            nameReceiver = fakeClient.last_name!!,
            e2e = "E"+  re.replace(fakeClient.phone_number!!, ""),
            amount = Random.nextInt(1,9999999).toString(),
            situation = true
        )
    }
}