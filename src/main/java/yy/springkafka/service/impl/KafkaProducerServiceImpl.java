package yy.springkafka.service.impl;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yy.springkafka.madel.Message;
import yy.springkafka.service.KafkaProducerService;

import java.util.Random;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    private final Producer producer;

    @Autowired
    public KafkaProducerServiceImpl(Producer producer) {
        this.producer = producer;

    }

    @Override
    public Message produce(Message message) {
        message.setId(new Random().nextLong());
        producer.beginTransaction();
        producer.send(
                new ProducerRecord<>(
                        "topicA",
                        String.valueOf(message.getId()),
                        message.getContent()));
        producer.commitTransaction();
        LOGGER.info("Produced message: id = {}, content = {}", message.getId(), message.getContent());
        return message;
    }
}
