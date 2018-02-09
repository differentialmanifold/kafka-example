package kafka.apm;

import com.alibaba.fastjson.JSON;
import kafka.Const;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ApmProducer {
    public static void main(String[] args) {
        Call call = new Call();

        call.setSpanId("abc");
        call.setCallId("callid");

        String json = JSON.toJSONString(call);

        KafkaProducer<String, String> producer = KafkaFactory.createKafkaProducer(Const.producerProperties);
        producer.send(new ProducerRecord<String, String>(Const.topic, json));

        producer.close();
    }
}
