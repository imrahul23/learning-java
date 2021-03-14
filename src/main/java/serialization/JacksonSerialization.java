package serialization;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonSerialization {
    public static void main(String[] args) throws IOException {
        String fileName = "user.ser";
        User user = new User();
        user.setName("Rahul");
        user.setId(1L);
        user.setAge(23);
        User.setKey("myKey");

        System.out.println(user.toString());

        writeJSON(user);
        User deserialized = readJSON();

        System.out.println(deserialized.toString());
    }

    private static void writeJSON(User user) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user.json"), user);
    }

    private static User readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("user.json"), User.class);
        return user;
    }
}
