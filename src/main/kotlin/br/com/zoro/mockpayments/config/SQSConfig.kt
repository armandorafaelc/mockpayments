package br.com.zoro.mockpayments.config

import com.amazonaws.services.sqs.AmazonSQSAsync
import io.awspring.cloud.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SQSConfig {

    @Bean
    fun queueMessagingTemplate(
        amazonSQSAsync: AmazonSQSAsync?
    ): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync)
    }
}