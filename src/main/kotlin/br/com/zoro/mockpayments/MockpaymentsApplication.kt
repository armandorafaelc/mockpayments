package br.com.zoro.mockpayments

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
class MockpaymentsApplication

fun main(args: Array<String>) {
	runApplication<MockpaymentsApplication>(*args)
}
