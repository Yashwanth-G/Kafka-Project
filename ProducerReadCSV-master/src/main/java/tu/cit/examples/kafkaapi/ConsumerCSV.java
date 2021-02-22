package tu.cit.examples.kafkaapi;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tu.cit.examples.kafkaapi.schemas.student;
import tu.cit.examples.kafkaapi.serde.JsonDeserializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class ConsumerCSV {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(student.class.getName());

        String bootstrapServers = "localhost:9092";
        String groupId = "my-grp1";
        String topic = "student";

        // create consumer configs
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, student.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // create consumer
        KafkaConsumer<String, student> consumer = new KafkaConsumer<>(properties);

        // subscribe consumer to our topic(s)
        consumer.subscribe(Arrays.asList(topic));
        // poll for new data
        while (true) {
            ConsumerRecords<String, student> records =
                    consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, student> record : records) {
//                logger.info("Key: " + record.key() + ", Value: " + record.value());
//                logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                String str = String.valueOf(record.value());
                String[] results = str.split(",");
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Where is your MySQL JDBC Driver?");
                    e.printStackTrace();
                    return;
                }

                System.out.println("MySQL JDBC Driver Registered!");
                Connection con = null;

                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun","root", "root");

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
                }

                if (con != null) {

                    System.out.println("Connection made.....");

                    try{

                        System.out.println("creating statements...");
                        Statement stmt = con.createStatement();

                        String sql = "INSERT INTO STUDENT " + "VALUES (str[0] ,str[1] , str[7], str[8])";
                        stmt.executeUpdate(sql);
                        System.out.println("Inserted records into the table...");


                        stmt.close();
                        con.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }} else {
                    System.out.println("Failed to make connection!");
                }
            }
        }
    }
}

