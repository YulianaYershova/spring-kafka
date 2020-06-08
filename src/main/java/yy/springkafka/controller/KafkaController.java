package yy.springkafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import yy.springkafka.dto.KafkaMessageDTO;
import yy.springkafka.madel.Message;
import yy.springkafka.service.KafkaConsumerService;
import yy.springkafka.service.KafkaProducerService;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaProducerService kafkaProducerService;
    private KafkaConsumerService kafkaConsumerService;

    public KafkaController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @PostMapping("/produce")
    @ResponseStatus(code = HttpStatus.OK)
    public Message produce(@RequestBody Message message) {
        return kafkaProducerService.produce(message);
    }

    @GetMapping("/consume")
    public List<KafkaMessageDTO> consume() {
        return kafkaConsumerService.consume();
    }
}
