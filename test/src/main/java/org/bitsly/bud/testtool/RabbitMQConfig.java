package org.bitsly.bud.testtool;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

/**
 * Created by liuhuan on 2018/12/13.
 */
//@Configuration
public class RabbitMQConfig {

  public final static String QUEUE_NAME = "spring-boot-queue";
  public final static String EXCHANGE_NAME = "spring-boot-exchange";
  public final static String ROUTING_KEY = "spring-boot-key";

//  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME);
  }

//  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(EXCHANGE_NAME);
  }

//  @Bean
  public Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
  }

}
