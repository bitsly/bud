package org.bitsly.bud.testtool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by liuhuan on 2018/12/13.
 */
@Slf4j
//@Component
public class Lister {

  @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
  public void consumeMessage(String message) {

    log.info("consume message {}", message);
  }

}
