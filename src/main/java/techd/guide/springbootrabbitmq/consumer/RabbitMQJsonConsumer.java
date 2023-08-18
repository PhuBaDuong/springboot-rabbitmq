package techd.guide.springbootrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import techd.guide.springbootrabbitmq.dto.User;

@Service
@Slf4j
public class RabbitMQJsonConsumer {
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMsg(User user) {
        log.info("Received json message # user={}", user);
    }
}
