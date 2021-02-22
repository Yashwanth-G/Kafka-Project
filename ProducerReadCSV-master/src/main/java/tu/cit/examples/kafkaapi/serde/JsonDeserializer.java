package tu.cit.examples.kafkaapi.serde;

import tu.cit.examples.kafkaapi.schemas.student;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public static final String VALUE_CLASS_NAME_CONFIG = "value.class.name";
    public JsonDeserializer(){}

    // @Override
    public void configure(Map<String,?> config, boolean isKey){}

    public T deserialize(String config, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        student s1 = null;
        try {
            s1 = mapper.readValue(bytes, student.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) s1;
    }

    public void close(){}

}
