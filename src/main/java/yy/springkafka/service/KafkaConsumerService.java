package yy.springkafka.service;

import yy.springkafka.dto.KafkaMessageDTO;
import yy.springkafka.madel.Message;

import java.util.List;

public interface KafkaConsumerService {
    List<KafkaMessageDTO> consume();
}
