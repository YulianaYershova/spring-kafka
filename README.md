# Simple spring-kafka application

#### How to start the spring-kafka application
1. Start ZooKeeper server ```bin/zookeeper-server-start.sh config/zookeeper.properties```
2. Start Kafka server ```bin/kafka-server-start.sh config/server.properties```
3. Create a topic ```bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic topicA```
4. Run ```mvn clean install``` to build application
5. Start application with ```java -jar target/spring-kafka-0.0.1-SNAPSHOT.jar```

