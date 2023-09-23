package io.pro.educare.application.configure;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    protected Queue queueDefault() {
        return new Queue("testing.rabbitMQ");
    }

}
