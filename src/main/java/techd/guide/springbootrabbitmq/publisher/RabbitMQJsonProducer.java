package techd.guide.springbootrabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import techd.guide.springbootrabbitmq.dto.User;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user)
    {
        log.info("Message sent # user={}", user);
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
