package techd.guide.springbootrabbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techd.guide.springbootrabbitmq.dto.User;
import techd.guide.springbootrabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Ok");
    }
}
