package hello;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.boot.jackson.JsonComponent;
import java.io.IOException;

@JsonComponent
public class HelloJsonSerializer extends JsonSerializer<Greeting> {

    public void serialize(Greeting greeting, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("Message", greeting.greet());
        jsonGenerator.writeEndObject();
    }
}