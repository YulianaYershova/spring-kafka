package yy.springkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KafkaMessageDTO {
    private String value;
    private String key;
    private String topic;
    private String offset;
    private String partition;
}
