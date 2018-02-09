package kafka.apm;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KafkaFactory {

    public static KafkaConsumer<String, String> createKafkaConsumer(String configName) {
        try {
            Properties properties = initProperties(configName);
            return new KafkaConsumer<String, String>(properties);
        } catch (Exception e) {
            throw new RuntimeException("create kafka consumer failed! cause by:" + e.getMessage());
        }
    }

    public static KafkaProducer<String, String> createKafkaProducer(String configName) {
        try {
            Properties properties = initProperties(configName);
            return new KafkaProducer<String, String>(properties);
        } catch (Exception e) {
            throw new RuntimeException("create kafka producer failed! cause by:" + e.getMessage());
        }
    }

    private static Properties initProperties(String configName) throws IOException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + configName;
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        return appProps;
    }
}
