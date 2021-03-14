package serialization.java;

import java.io.IOException;

public class SerializationTest {
    public static void main(String[] args) {
        String fileName = "user.ser";
        User user = new User();
        user.setName("Rahul");
        user.setId(1L);
        user.setAge(23);
        User.setKey("myKey");

        try {
            SerializationUtil.serialize(user, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User deserialized = null;
        try {
            deserialized = (User) SerializationUtil.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());
        System.out.println(deserialized.toString());
    }
}
