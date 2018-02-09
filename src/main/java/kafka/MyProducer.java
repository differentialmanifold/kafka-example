package kafka;

import kafka.apm.KafkaFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {
    public static void main(String[] args) {

        Producer<String, String> producer = KafkaFactory.createKafkaProducer(Const.producerProperties);
//        for (int i = 0; i < 5; i++)
//            producer.send(new ProducerRecord<String, String>(Const.topic, Integer.toString(i), Integer.toString(i)));
//
//        producer.close();
        String msg = "{\"agentId\":\"0012\",\"applicationName\":\"firstservice\",\"callId\":\"115179115034932345678rvice000022354723d2575d480bbdfec03de4e21e14\",\"devGroupKey\":\"12345678\",\"id\":\"115179115034931345678rvice000012f580963c1ea64dce94bf4334031ca6c4\",\"internal\":true,\"methodUri\":\"demo.dubbo.first.service.FirstService:getOneById([int])\",\"mixStatus\":0,\"nano\":\"687191\",\"parentSpanId\":\"115179115026971345678rvice00002287cf3172b36242819a4351d9922ce436\",\"serverType\":2,\"spanContext\":\"{\\\\\"arguments\\\\\":\\\\\"[4]\\\\\",\\\\\"jumpSpan\\\\\":false}\",\"srTime\":1517911503509,\"ssTime\":1517911503604,\"status\":0,\"traceId\":\"115179115026970345678rvice0000229c7aa12cb1b64b818a7c2e6720995782\",\"tryCount\":0}";
        producer.send(new ProducerRecord<String, String>(Const.topic, msg));
        producer.close();
    }
}
