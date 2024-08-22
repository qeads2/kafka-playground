package com.example.kafkaplayground.config

import com.example.kafkaplayground.domain.OrderCompleted
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory

@Configuration
@EnableKafka
class KafkaConsumerConfig {
    @Bean
    fun consumerFactory(): ConsumerFactory<String, OrderCompleted> {
        val deserializer = JsonDeserializer(OrderCompleted::class.java)
        deserializer.addTrustedPackages("*")
        val errorHandlingDeserializer = ErrorHandlingDeserializer(deserializer)

        val props: MutableMap<String, Any> = HashMap()
        return DefaultKafkaConsumerFactory(
            props,
            StringDeserializer(),
            errorHandlingDeserializer
        )
    }

    @Bean
    fun myContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, OrderCompleted> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, OrderCompleted>()
        factory.consumerFactory = consumerFactory()
        return factory
    }

}