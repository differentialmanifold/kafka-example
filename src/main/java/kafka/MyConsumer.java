package kafka;

import kafka.apm.KafkaFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;

public class MyConsumer {
    public static void main(String[] args) {
        KafkaConsumer<String, String> consumer = KafkaFactory.createKafkaConsumer(Const.consumerProperties);
        consumer.subscribe(Arrays.asList(Const.topic));
        consumer.poll(0);
        consumer.seekToBeginning(new ArrayList<>());
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}
