package br.com.zoro.mockpayments.aspect

import io.micrometer.core.instrument.MeterRegistry
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*


@Aspect
@Component
class MeterRegistryAspect(
	private val meterRegistry: MeterRegistry
) {
	val log = LoggerFactory.getLogger(this.javaClass)

	@After("execution(* br.com.zoro.mockpayments.producer..*(..))")
	fun allMethodsProducer() {
		meterRegistry.counter("GerandoEvento", "gerandoEvento", UUID.randomUUID().toString())
	}

}