package kafka.apm;

import com.alibaba.fastjson.JSON;
import kafka.Const;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ApmConsumer {
    public static void main(String[] args) throws IOException {
        KafkaConsumer<String, String> consumer = KafkaFactory.createKafkaConsumer(Const.consumerProperties);

        consumer.subscribe(Arrays.asList(Const.topic));

//        ConsumerRecords<String, String> records = consumer.poll(0);
//        consumer.seekToBeginning(new ArrayList<>());
        ConsumerRecords<String, String> records = null;

//        for (int i = 0; i < 5; i++) {
        while (true) {
//            System.out.println(i);
            records = consumer.poll(10);
            deserialize(records);
        }


//        consumer.close();
    }

    public static void deserialize(ConsumerRecords<String, String> records) {
        for (ConsumerRecord<String, String> record : records) {
            Call call = JSON.parseObject(record.value(), Call.class);
            System.out.println(call);
        }
    }
}
