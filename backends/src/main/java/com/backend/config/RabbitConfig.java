package com.backend.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	  public static final String QUEUE_NAME = "cola_turnos";
	    public static final String EXCHANGE_NAME = "exchange_turnos";

	    @Bean
	    public Queue queue() {
	        return new Queue(QUEUE_NAME, true);
	    }

	    @Bean
	    public TopicExchange exchange() {
	        return new TopicExchange(EXCHANGE_NAME);
	    }

	    @Bean
	    public Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with("turno.nuevo");
	    }
}
