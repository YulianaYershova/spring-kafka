package yy.springkafka.service;

import yy.springkafka.madel.Message;

public interface KafkaProducerService {
    Message produce(Message message);
}
