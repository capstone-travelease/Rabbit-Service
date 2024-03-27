package com.RabbitService.Configure;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private String queueBook = "queue_book";
    private String queuePayment = "queue_payment";

    // config exchange
    private String exchange_book = "exchange_book";
    private String exchange_payment = "exchange_payment";

    // config routing
    private String routing_book = "book_route_key";
    private String routing_payment= "payment_route_key";

    @Bean
    public Queue queue(){
        return new Queue(queueBook);
    }


    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange_book);
    }

    // binding between queue and exchange using routing key

    @Bean
    public Binding bind(){
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(routing_book);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
