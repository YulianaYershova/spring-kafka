package yy.springkafka.service.impl;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yy.springkafka.dto.KafkaMessageDTO;
import yy.springkafka.service.KafkaConsumerService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final Consumer consumer;

    @Autowired
    public KafkaConsumerServiceImpl(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public List<KafkaMessageDTO> consume() {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(30));
        List<KafkaMessageDTO> kafkaMessageDTOList = new ArrayList<>();
        for (ConsumerRecord<String, String> record : records) {
            LOGGER.info("Consumed message: topic = {}, offset = {}, key = {}, value = {}", record.topic(), record.offset(), record.key(), record.value());
            kafkaMessageDTOList.add(new KafkaMessageDTO(record.value(),
                    record.key(),
                    record.topic(),
                    String.valueOf(record.offset()),
                    String.valueOf(record.partition())));
        }
        consumer.commitAsync();
        return kafkaMessageDTOList;
    }
}
