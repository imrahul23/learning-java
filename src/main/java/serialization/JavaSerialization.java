package serialization;

import java.io.*;

public class JavaSerialization {
    public static void main(String[] args) {
        String fileName = "user.ser";
        User user = new User();
        user.setName("Rahul");
        user.setId(1L);
        user.setAge(23);
        User.setKey("myKey");

        try {
            serialize(user, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User deserialized = null;
        try {
            deserialized = (User) deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());
        System.out.println(deserialized.toString());
    }

    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        fileOutputStream.close();
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
        Object obj = objectOutputStream.readObject();
        return obj;
    }

}
